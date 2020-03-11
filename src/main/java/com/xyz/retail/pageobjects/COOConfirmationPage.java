package com.xyz.retail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.vanguard.selenium.inner.base.PageNavigationException;
import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class COOConfirmationPage extends VanguardBasePageImpl {

	By pageHeader = By.xpath("//h1[text()='Confirmation']");
	By confirmationNumber = By.xpath("//h2[contains(text(),'Confirmation')]");
	By doneButton = By.id("validatedInputForm:doneBtnInput");

	public COOConfirmationPage(WebDriver driver) {
		super(driver);
		if (!isCurrentlyLoaded()) {
			throw new PageNavigationException("crave page is not loaded");
		}
	}

	@Override
	public boolean isCurrentlyLoaded() {
		return isDisplayed(pageHeader, 30);
	}

	public String getConfirmationNumberInSummaryPage() {
		return getText(confirmationNumber, 10).replaceAll("\\D+", "");
	}

	public String getVastAccountNumber(String fund) {
		By fundAndAccount = By.xpath("//td[contains(text(),'" + fund + "')]//following::td//following-sibling::td");
		return getText(fundAndAccount, 5);
	}

	public void clickDoneButton() {
		click(doneButton, 5);
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
