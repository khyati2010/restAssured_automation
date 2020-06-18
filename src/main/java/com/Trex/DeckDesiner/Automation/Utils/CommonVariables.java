
package com.Trex.DeckDesiner.Automation.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class CommonVariables {

	public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> currentTestClassLog = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> currentTestCaseLog = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<String> currentTestCaseName = new ThreadLocal<String>();
	public static ThreadLocal<String> currentTestClassName = new ThreadLocal<String>();
	public static ThreadLocal<String> currentTestClassResult = new ThreadLocal<String>();
	public static ThreadLocal<String> currentTestCaseResult = new ThreadLocal<String>();

	public static ExtentTest getCurrentTestClassLog() {
		return currentTestClassLog.get();
	}

	public static void setCurrentTestClassLog(ExtentTest currentTestClassLog) {
		CommonVariables.currentTestClassLog.set(currentTestClassLog);
	}

	public static ExtentTest getCurrentTestCaseLog() {
		return currentTestCaseLog.get();
	}

	public static void setCurrentTestCaseLog(ExtentTest currentTestCaseLog) {
		CommonVariables.currentTestCaseLog.set(currentTestCaseLog);
	}

	public static String getCurrentTestCaseName() {
		return currentTestCaseName.get();
	}

	public static void setCurrentTestCaseName(String currentTestCaseName) {
		CommonVariables.currentTestCaseName.set(currentTestCaseName);
	}

	public static String getCurrentTestClassName() {
		return currentTestClassName.get();
	}

	public static void setCurrentTestClassName(String currentTestClassName) {
		CommonVariables.currentTestClassName.set(currentTestClassName);
	}

	public static String getCurrentTestClassResult() {
		return currentTestClassResult.get();
	}

	public static void setCurrentTestClassResult(String currentTestClassResult) {
		CommonVariables.currentTestClassResult.set(currentTestClassResult);
	}

	public static String getCurrentTestCaseResult() {
		return currentTestCaseResult.get();
	}

	public static void setCurrentTestCaseResult(String currentTestCaseResult) {
		CommonVariables.currentTestCaseResult.set(currentTestCaseResult);
	}

}
