package com.epam.lab.homeWork.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GmailPageObject {
	protected WebDriver driver;
	protected int pageUpdateTimeOut;

	public GmailPageObject(WebDriver driver, int pageUpdateTimeOut) {
		this.driver = driver;
		this.pageUpdateTimeOut = pageUpdateTimeOut;
	}

	protected void waitUntilIsVisible(WebElement webElement) {
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
