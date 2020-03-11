package com.xyz.retail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.vanguard.selenium.inner.base.PageNavigationException;
import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class DataManagementInterfacePage extends VanguardBasePageImpl {

	By dataManagementDropDown = By.partialLinkText("Data Management");
	By reviewAndExportOption = By.xpath("//div[contains(text(),'Review')][contains(text(),'Export')]");
	By receiveAndDeliverOption = By.xpath("//div[contains(text(),'Receive')][contains(text(),'Deliver')]");
	By accountNumberTextBox = By.xpath("//input[@name='accountNo']");
	By goButton = By.id("submit");
	By sviSourceCodeDropDown = By.id("svi_source_cd");

	public DataManagementInterfacePage(WebDriver driver) {
		super(driver);
		if (!isCurrentlyLoaded()) {
			throw new PageNavigationException("Can't load " + this.getClass().getSimpleName() + " Page.", driver);
		}
	}

	@Override
	public boolean isCurrentlyLoaded() {
		return isDisplayed(dataManagementDropDown, 30);
	}

	public void selectReceiveAndDeliver() {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(dataManagementDropDown, 5)).build().perform();
		action.moveToElement(findElement(reviewAndExportOption, 5)).build().perform();
		click(receiveAndDeliverOption, 5);
	}

	public void searchAccountNumberInRAD(String accountNumber) {
		clearAndType(accountNumber, accountNumberTextBox, 5);
		click(goButton, 5);
	}

	public boolean goToTransaction(String zNumber) {
		By editLink = By
				.xpath("//td[contains(text(),'" + zNumber + "')]//preceding-sibling::td//img[contains(@title,'Edit')]");
		if (isDisplayed(editLink, 5)) {
			click(editLink);
			return true;
		}
		return false;
	}

	public boolean verifyAccountNumber(String accountNumber) {
		By accountNumberLocator = By.xpath("//input[@id='acct_no' and contains(@value,'" + accountNumber + "')]");
		return isDisplayed(accountNumberLocator, 5);
	}

	public boolean verifySviSourceCode(String sviSourceCode) {
		Select dropDown = new Select(findElement(sviSourceCodeDropDown, 5));
		return dropDown.getFirstSelectedOption().getText().contains(sviSourceCode);
	}

	public boolean verifyTranCtnNumber(String tranCtnNumber) {
		By tranCtnNumberLocator = By.xpath("//input[@id='tran_ctn_num' and contains(@value,'" + tranCtnNumber + "')]");
		return isDisplayed(tranCtnNumberLocator, 5);
	}

	public boolean verifyInOutFirmNumber(String inOutFirmNumber) {
		By inOutFirmNumberLocator = By
				.xpath("//input[@id='in_out_firm_num' and contains(@value,'" + inOutFirmNumber + "')]");
		return isDisplayed(inOutFirmNumberLocator, 5);
	}

	public boolean verifyInOutFirmAccountNumber(String inOutFirmAccountNumber) {
		By inOutFirmAccountNumberLocator = By
				.xpath("//input[@id='in_out_firm_acct_no' and contains(@value,'" + inOutFirmAccountNumber + "')]");
		return isDisplayed(inOutFirmAccountNumberLocator, 5);
	}

	public boolean verifyProcessStatus(String processStatus) {
		By processStatusLocator = By
				.xpath("//input[@id='process_status' and contains(@value,'" + processStatus + "')]");
		return isDisplayed(processStatusLocator, 5);
	}

	public boolean verifyCBRSTransferType(String transferType) {
		By transferTypeLocator = By.xpath("//input[@id='transfer_type' and contains(@value,'" + transferType + "')]");
		return isDisplayed(transferTypeLocator, 5);
	}

}
