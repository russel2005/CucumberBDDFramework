package com.xyz.retail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vanguard.selenium.inner.base.PageNavigationException;
import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class ChangeOfOwnershipPage extends VanguardBasePageImpl {

	By pageHeader = By.xpath("//h1[contains(text(),'Change of ownership')]");
	By fromClientDropDown = By.id("validatedInputForm:fromOptionsMenu_text");
	By memoTextBox = By.id("validatedInputForm:textAreaMemo");
	By fromClientContinueButton = By.id("validatedInputForm:fromContinueButtonInput");
	By toAccountSearchBox = By.id("validatedInputForm:toAccountSearchBox");
	By toSearchButton = By.id("validatedInputForm:toSearchButtonInput");
	By changeTypeDropDown = By.id("validatedInputForm:toOptionsMenu_text");
	By toClientContinueButton = By.id("validatedInputForm:continueBtnInput");
	By sharesTextBox = By.xpath("//input[contains(@id,'validatedInputForm:curLotSelectionRow')]");
	By selectLotsContinueButton = By.id("validatedInputForm:continueButtonInput");
	By continueButton = By.id("validatedInputForm:continueBtnInput");
	By selectHoldingsForm = By.xpath("//h1[contains(text(),'Select holdings')]");
	By cooForm = By.id("validatedInputForm:");

	public ChangeOfOwnershipPage(WebDriver driver) {
		super(driver);
		if (!isCurrentlyLoaded()) {
			throw new PageNavigationException("crave page is not loaded");
		}
	}

	@Override
	public boolean isCurrentlyLoaded() {
		return isDisplayed(pageHeader, 30);
	}

	public void selectFromClient(String account) {
		By accountLocator = By.xpath("//td[text()='" + account + "']");
		click(fromClientDropDown, 5);
		click(accountLocator, 5);
	}

	public void enterMemo(String memo) {
		clearAndType(memo, memoTextBox, 5);
	}

	public void clickFromClientContinueButton() {
		click(fromClientContinueButton, 5);
	}

	public void searchForAVBAAccount(String account) {
		clearAndType(account, toAccountSearchBox, 5);
		click(toSearchButton, 5);
	}

	public void selectTypeOfchange(String changeType) {
		By changeTypeLocator = By.xpath("//td[contains(text(),'" + changeType + "')]");
		click(changeTypeDropDown, 5);
		click(changeTypeLocator, 5);
	}

	public void clickToClientContinueButton() {
		click(toClientContinueButton, 5);
	}

	public void selectSharesInLotToTransfer(String fundSymbol, String shares) {
		By selectLotsLink = By.xpath("//td[contains(text(),'" + fundSymbol + "')]//following-sibling::td//a");
		isDisplayed(selectHoldingsForm, 3);
		click(selectLotsLink, 5);
		clearAndType(shares, sharesTextBox, 5);
		click(selectLotsContinueButton, 5);
	}

	public void clickContinueButton() {
		isDisplayed(cooForm, 3);
		click(continueButton, 5);
	}
}
