package com.epam.lab.homeWork.listener;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class GmailTestListener implements ITestListener {

	private static final Logger LOGGER = LogManager.getLogger(GmailTestListener.class);

	@Override
	public void onFinish(ITestContext testContext) {
		LOGGER.info(String.format("Finishing %s", testContext.getName()));
	}

	@Override
	public void onStart(ITestContext testContext) {
		LOGGER.info(String.format("Starting %s", testContext.getName()));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
		LOGGER.info(String.format("Test %s with parameters %s ended with failure (Success percentage OK)",
				testResult.getMethod().getMethodName(), Arrays.asList(testResult.getParameters())));
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		LOGGER.info(String.format("Test %s with parameters %s ended with failure",
				testResult.getMethod().getMethodName(), Arrays.asList(testResult.getParameters())));
	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		LOGGER.info(String.format("Test %s with parameters %s skipped", testResult.getMethod().getMethodName(),
				Arrays.asList(testResult.getParameters())));
	}

	@Override
	public void onTestStart(ITestResult testResult) {
		LOGGER.info(String.format("Starting test %s with parameters: %s", testResult.getMethod().getMethodName(),
				Arrays.asList(testResult.getParameters())));
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		LOGGER.info(String.format("Test %s with parameters %s passed successfully",
				testResult.getMethod().getMethodName(), Arrays.asList(testResult.getParameters())));

	}

}
