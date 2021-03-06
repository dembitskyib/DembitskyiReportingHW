package com.epam.lab.homeWork.pageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends Element {
	public Button(WebElement webElement) {
		super(webElement);
	}

	public void clickWithJs(WebDriver driver, int timeOut) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webElement);
	}

	public void click(WebDriver driver, int timeOut) {
		if (isClickable(driver, timeOut) && webElement.isDisplayed()) {
			super.click();
		}
	}

	public boolean isClickable(WebDriver driver, int timeOut) {
		boolean isClickable = true;
		try {
			(new WebDriverWait(driver, timeOut)).until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (Exception ex) {
			isClickable = false;
		}
		return isClickable;
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}
}
