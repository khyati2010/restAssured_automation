package com.automation.Utils;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.SetUp.TestSetup;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners extends TestSetup implements ITestListener {

	public void onTestStart(ITestResult result) {

		ExtentTest test = CommonVariables.getCurrentTestClassLog().createNode(result.getName());
		CommonVariables.setCurrentTestCaseLog(test);

		CommonVariables.getCurrentTestCaseLog().assignAuthor(System.getProperty("user.name").replace(".", " "));

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Passed" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		CommonVariables.getCurrentTestCaseLog().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String testClassName = result.getTestClass().getName();
		System.out.println("Test Class Name:- "+testClassName);
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());

		if (testClassName.contains("API")) {
			CommonVariables.getCurrentTestCaseLog()
					.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
							+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>")
							+ "</details>" + " \n");

		} else {
			try {
				TestUtils.captureScreenshot();
			} catch (Exception e) {

				e.printStackTrace();
			}
			CommonVariables.getCurrentTestCaseLog()
					.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
							+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>")
							+ "</details>" + " \n");

			try {

				System.out.println("ScreenshotPath->" + configProperty.getScreenShotsPath());
				System.out.println("ScreenshotName->" + TestUtils.getScreenShotName());
				CommonVariables.getCurrentTestCaseLog()
						.fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>")
						.addScreenCaptureFromPath(System.getProperty("user.dir")+configProperty.getScreenShotsPath()+TestUtils.getScreenShotName());

			} catch (IOException e) {

			}

		}

		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		CommonVariables.getCurrentTestCaseLog().log(Status.FAIL, m);

		// extentLogger().info()

	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		CommonVariables.getCurrentTestCaseLog().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
