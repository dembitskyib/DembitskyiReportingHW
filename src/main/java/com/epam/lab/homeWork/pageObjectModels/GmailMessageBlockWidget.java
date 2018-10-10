package com.epam.lab.homeWork.pageObjectModels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.lab.homeWork.dataModels.Message;
import com.epam.lab.homeWork.pageElements.Button;
import com.epam.lab.homeWork.pageElements.DivTextInput;
import com.epam.lab.homeWork.pageElements.Input;
import com.epam.lab.homeWork.utils.CustomFieldDecorator;

public class GmailMessageBlockWidget extends GmailPageObject {
	private WebDriver driver;
	@FindBy(css = "*[name='to']")
	private DivTextInput receiverInputField;
	@FindBy(xpath = "//span[contains(@class, 'aB') and contains(@class ,'gQ') and contains(@class ,'pE')]")
	private Button copyReceiverButton;
	@FindBy(css = "*[name='cc']")
	private DivTextInput copyReceiverInputField;
	@FindBy(xpath = "//span[contains(@class, 'aB') and contains(@class ,'gQ') and contains(@class ,'pB')]")
	private Button hiddenCopyReceiverButton;
	@FindBy(css = "*[name='bcc']")
	private DivTextInput hiddenCopyReceiverInputField;
	@FindBy(css = "*[name='subjectbox']")
	private DivTextInput subjectInputField;
	@FindBy(xpath = "//*[@role='textbox']")
	private DivTextInput messageInput;
	@FindBy(xpath = "//img[@class='Ha']")
	private Button saveAndCloseButton;
	@FindBy(xpath = "//input[@name = 'to']")
	private Input receiverInput;
	@FindBy(xpath = "//input[@name = 'cc']")
	private Input ccInput;
	@FindBy(xpath = "//input[@name = 'bcc']")
	private Input bccInput;
	@FindBy(xpath = "//input[@name = 'subject']")
	private Input subjectInput;

	public GmailMessageBlockWidget(WebDriver driver, int pageUpdateTimeOut) {
		super(driver, pageUpdateTimeOut);
		this.driver = driver;
		PageFactory.initElements(new CustomFieldDecorator(driver), this);
	}

	public void typeReceiver(String receiver) {
		waitUntilIsVisible(receiverInputField.getWebElement());
		receiverInputField.type(receiver);
	}

	public void typeCopyReceiver(String receiver, int timeOut) {
		copyReceiverButton.click(driver, timeOut);
		copyReceiverInputField.type(receiver);
	}

	public void typeHiddenCopyReceiver(String receiver, int timeOut) {
		hiddenCopyReceiverButton.click(driver, timeOut);
		hiddenCopyReceiverInputField.type(receiver);
	}

	public void typeSubject(String subject) {
		subjectInputField.type(subject);
	}

	public void typeMessage(String message) {
		messageInput.type(message);
	}

	public boolean checkComposeFields(Message message) {
		return receiverInput.getValue().equals(message.getTo()) || ccInput.getValue().equals(message.getCc())
				|| bccInput.getValue().equals(message.getBcc()) || subjectInput.getValue().equals(message.getSubject())
				|| messageInput.getText().equals(message.getText()) ? true : false;
	}

	public void saveAndClose(int timeOut) {
		saveAndCloseButton.click(driver, timeOut);
	}

	public void clickSendButton() {
		String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
		messageInput.type(keysPressed);
	}
}
