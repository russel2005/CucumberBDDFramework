package com.xyz.retail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vanguard.selenium.inner.base.PageNavigationException;
import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class COOReviewAndSubmitPage extends VanguardBasePageImpl {

	By pageHeader = By.xpath("//h1[text()='Review and submit']");
	By submitButton = By.id("validatedInputForm:continueBtnInput");
	By submitPageForm = By.id("validatedInputForm:");

	public COOReviewAndSubmitPage(WebDriver driver) {
		super(driver);
		if (!isCurrentlyLoaded()) {
			throw new PageNavigationException("crave page is not loaded");
		}
	}

	@Override
	public boolean isCurrentlyLoaded() {
		return isDisplayed(pageHeader, 30);
	}

	public void clickSubmitButton() {
		isDisplayed(submitPageForm, 3);
		click(submitButton, 5);
	}

	public boolean verifyToAccount(String toAccount) {
		By toAccountLocator = By.xpath(
				"//td[contains(text(),'To account')]//following-sibling::td[contains(text(),'" + toAccount + "')]");
		return isDisplayed(toAccountLocator, 5);
	}

	public boolean verifyFromAccount(String fromAccount) {
		By fromAccountLocator = By.xpath(
				"//td[contains(text(),'From account')]//following-sibling::td[contains(text(),'" + fromAccount + "')]");
		return isDisplayed(fromAccountLocator, 5);
	}

	public boolean verifyShareQuantity(String shares) {
		By shareQuantity = By
				.xpath("//tr[contains(@tbodyid,'validatedInputForm')]//td[contains(text(),'" + shares + "')]");
		return isDisplayed(shareQuantity, 5);
	}

}
