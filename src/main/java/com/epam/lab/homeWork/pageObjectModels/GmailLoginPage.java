package com.epam.lab.homeWork.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.lab.homeWork.pageElements.Button;
import com.epam.lab.homeWork.pageElements.DivTextInput;
import com.epam.lab.homeWork.utils.CustomFieldDecorator;

public class GmailLoginPage extends GmailPage {
	@FindBy(xpath = "//input[@type = 'email']")
	private DivTextInput emailInput;
	@FindBy(xpath = "//div[@id = 'identifierNext']//span")
	private Button emailSubmit;
	@FindBy(name = "password")
	private DivTextInput passwordInput;
	@FindBy(css = "#passwordNext")
	private Button passwordSubmit;
	private WebDriver driver;
	private int pageUpdateTimeOut;

	public GmailLoginPage(WebDriver driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
		this.pageUpdateTimeOut = pageUpdateTimeOut;
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
		this.driver = driver;
	}

	public void typeEmailAndSubmit(String login) {
		waitPageUpdate();
		emailInput.type(login);
		emailSubmit.click(driver, pageUpdateTimeOut);
	}

	public GmailHomePage typePasswordAndSubmit(String password) {
		passwordInput.sendKeys(password);
		passwordSubmit.clickWithJs(driver, pageUpdateTimeOut);
		return new GmailHomePage(driver, pageUpdateTimeOut);
	}

	private void waitPageUpdate() {
		try {
			(new WebDriverWait(driver, pageUpdateTimeOut)).until(ExpectedConditions.urlContains("signin"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
