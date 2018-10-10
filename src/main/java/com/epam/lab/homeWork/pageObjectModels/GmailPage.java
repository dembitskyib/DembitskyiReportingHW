package com.epam.lab.homeWork.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GmailPage extends GmailPageObject {

	public GmailPage(WebDriver driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
	}

	public void redirectToPage(String url) {
		driver.get(url);
	}

	public boolean isURLCorrect(String expectedURL) {
		boolean isComparisionFailed = false;
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(ExpectedConditions.urlContains(expectedURL));
		} catch (Exception ex) {
			isComparisionFailed = true;
		}
		return !isComparisionFailed;
	}

}
