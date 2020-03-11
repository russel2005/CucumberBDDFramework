package com.xyz.retail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.vanguard.selenium.inner.base.PageNavigationException;
import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class ScivantageSearchPage extends VanguardBasePageImpl {

	By searchPageHeader = By.xpath("//h1[contains(text(),'Search')]");
	By dataManagementLink = By.partialLinkText("Data Management");
	By viewDropDownLocator = By.id("initialView");
	By accountNumberTextBox = By.id("account");
	By fundSymbolTextBox = By.id("securityID");
	By submitButton = By.xpath("//input[@value='Submit']");

	public ScivantageSearchPage(WebDriver driver) {
		super(driver);
		if (!isCurrentlyLoaded()) {
			throw new PageNavigationException("Can't load " + this.getClass().getSimpleName() + " Page.", driver);
		}
	}

	@Override
	public boolean isCurrentlyLoaded() {
		return isDisplayed(searchPageHeader, 30);
	}

	public void navigateToDataManagementInterfaceScreen() {
		click(dataManagementLink, 5);
	}

	public void selectViewType(String viewDropDownOption) {
		Select viewDropDown = new Select(findElement(viewDropDownLocator, 5));
		viewDropDown.selectByVisibleText(viewDropDownOption);
	}

	public void enterAccountNumberInSearchCriteria(String account) {
		clearAndType(account, accountNumberTextBox, 5);
	}

	public void enterFundSymbolInSearchCriteria(String fundSymbol) {
		clearAndType(fundSymbol, fundSymbolTextBox, 5);
	}

	public void submitSearch() {
		click(submitButton, 5);
	}

	public boolean verifyLotInformationInMaxitLedger(String transactionType, String lot) {
		By transactionRecordWithLots = By.xpath("//div[contains(text(),'" + transactionType
				+ "')]/../following-sibling::td//div[contains(text(),'" + lot + "')]");
		return isDisplayed(transactionRecordWithLots, 5);
	}

}
