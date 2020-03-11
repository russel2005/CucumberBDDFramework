package com.xyz.retail.pageobjects;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vanguard.selenium.inner.core.pages.VanguardBasePageImpl;

public class CostBasisSummaryPage extends VanguardBasePageImpl {

	By giftedShares = By.xpath("//span[contains(text(),'Gifted shares')]");

	By currentYearToDate = By.xpath("//span[contains(text(),'2018 â€“year-to-date')]");

	By validLinks = By.xpath("//div[contains(@class,'linkBarWrapper')]//a[contains(@id,'cbaPortfolioSummary')]");

	By accountNumberColumn = By.xpath("//th[contains(text(),'Name/Account number')]");

	By costBasisMethodColumn = By.xpath("//a[contains(text(),'Cost basis method')]");

	By giftValueColumn = By.xpath("//a[contains(text(),'Gift value')]");

	By recipientColumn = By.xpath("//a[contains(text(),'Recipient')]");
	By accountNameDropDown = By.id("cbaPortfolioSummary:cbAccountDropDown_main");

	By showDetailslabel = By.xpath("//span[@class='vg-NavboxLabel']");
	By historyDropDown = By.xpath("//span[@id='HistorySummaryForm:accountSelectOneMenu_text']");

	By transactionHistoryLink = By.xpath(("//ul[@class='vgc-navigationSubSection']//li/a[@href='/us/TransHistory']"));
	By transactionDate = By
			.xpath("//div[contains(@style,'block')]//tr[contains(@id,'LotTableForm_lotDataTable')]//td[1]");
	By transactionQuantity = By
			.xpath("//div[contains(@style,'block')]//tr[contains(@id,'LotTableForm_lotDataTable')]//td[4]");
	By giftedSharesText = By.xpath(
			"//td[contains(text(),'You don') and contains(text(), 'have any gifts of shares from your account at this time')]");
	By showDetails = By.xpath("//span[@class='NavboxLabel']");
	By costBasisSummaryForm = By.id("HistorySummaryForm:");
	By giftedSharesTable = By.xpath("//table[contains(@id,'giftTabForm:dataTableAccount_')]");
	By maxitVBS = By.partialLinkText("Maxit VBS");
	By maxitMutualFund = By.partialLinkText("Maxit Mutual Fund");
	List<String> fundnames = new ArrayList<String>();
	List<String> transactionDetails = new ArrayList<String>();

	public CostBasisSummaryPage(WebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isCurrentlyLoaded() {

		return false;
	}

	public boolean verifyValidLinks() {

		List<WebElement> links = driver.findElements(validLinks);
		System.out.println("total links: " + links.size());
		return isDisplayed(validLinks, 10);
	}

	public void selectAccountFromDropDownInCostBasisSummaryPage(String accountName) {
		openCBDDropdown(accountNameDropDown);
		By selectAccount = By.xpath("//td[contains(text(),'" + accountName + "')]");
		click(selectAccount, 10);
		// isDisplayed(showDetails, 6);
	}

	public void clickGiftedSharesTab() {
		click(giftedShares, 10);

	}

	public boolean isCurrentYearToDateDefault() {
		String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		return currentYear.contains(getText(currentYearToDate));

	}

	public boolean verifyCorrectDataPopulatesInCorrectColumn(String fundSymbol) {
		By fundName = By.xpath("//td[contains(text(),'" + fundSymbol + "')]");
		return getText(accountNumberColumn).contains(getText(fundName));

	}

	public boolean veirfyDataPopulatesInCostBasisSummaryspage(String accountNumber) {
		int tableDataPresentCounter = 0;
		isDisplayed(giftedSharesTable, 20);
		WebElement table = findElement(giftedSharesTable);

		if (table != null) {

			List<WebElement> giftedSharesTableRows = table.findElements(By.tagName("tr"));
			System.out.println("number of rows: " + giftedSharesTableRows.size());
			/*
			 * for (int rnum = 5; rnum < giftedSharesTableRows.size() - 2; rnum
			 * = rnum + 2) {
			 * 
			 * List<WebElement> giftedSharesTableColumns =
			 * giftedSharesTableRows.get(rnum) .findElements(By.tagName("td"));
			 * 
			 * if (giftedSharesTableColumns.size() != 1) {
			 * fundnames.add(giftedSharesTableColumns.get(0).getText());
			 * 
			 * for (int cnum = 0; cnum < giftedSharesTableColumns.size();
			 * cnum++)
			 * 
			 * {
			 * 
			 * fundnames.add(giftedSharesTableColumns.get(0).getText());
			 * 
			 * if
			 * (giftedSharesTableColumns.get(2).getText().equalsIgnoreCase("")
			 * ||
			 * giftedSharesTableColumns.get(6).getText().equalsIgnoreCase("")) {
			 * 
			 * } else { if
			 * (giftedSharesTableColumns.get(cnum).getText().equalsIgnoreCase(""
			 * )) { tableDataPresentCounter = tableDataPresentCounter + 1; }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * }
			 */
		} else {
			tableDataPresentCounter = tableDataPresentCounter + 1;
		}

		if (tableDataPresentCounter == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void getShowDetailsData() {

		List<WebElement> showDetailsLinks = findElements(showDetailslabel, 20);

		for (WebElement element : showDetailsLinks) {
			isDisplayed(showDetails, 3);
			click(element);
			isDisplayed(transactionDate, 10);
			transactionDetails.add(getText(transactionDate) + "," + getText(transactionQuantity));

			click(element);

		}

	}

	public void clickShowDetailsLabel() {
		click(showDetailslabel, 10);

	}

	public boolean verifyTransactionHistoryPage() {

		int transactionHistoryRecordExistsCounter = 0;
		boolean transactionHistoryRecordExists = false;

		for (int i = 0; i < transactionDetails.size(); i++) {

			By transactionRecord = By
					.xpath("//table[@id='HistorySummaryForm:viaHistoryDataTable']//td[contains(text(),'"
							+ transactionDetails.get(i).split(",")[0] + "')]//following-sibling::td[contains(text(),'"
							+ fundnames.get(i) + "')]//following-sibling::td[contains(text(),'"
							+ transactionDetails.get(i).split(",")[1] + "')]");
			if (isDisplayed(transactionRecord)) {
				transactionHistoryRecordExistsCounter++;
			}

		}
		if (transactionHistoryRecordExistsCounter != 0) {
			transactionHistoryRecordExists = true;
			return transactionHistoryRecordExists;
		} else {
			return transactionHistoryRecordExists;
		}

	}

	public void clickTransactionHistoryLink() {
		click(transactionHistoryLink, 10);

	}

	public void selectAccountFromDropDownInTransactionHistoryPage(String accountNumber) {
		By transactionHostoryAccount = By.xpath("//td[contains(text(),'" + accountNumber + "')]");
		openCBDDropdown(historyDropDown);
		click(transactionHostoryAccount, 10);
		isDisplayed(showDetails, 7);

	}

	public boolean verifyProvidedMutualFundDoesNotExistsInGiftedSharesTab(String accountNumber, String fundSymbol) {
		boolean isMutualFundExists = false;
		if (isDisplayed(giftedSharesText, 20)) {
			return isMutualFundExists;
		} else if (!isDisplayed(giftedSharesText, 20)) {
			veirfyDataPopulatesInCostBasisSummaryspage(accountNumber);
			if (fundnames.contains(fundSymbol)) {
				isMutualFundExists = true;

			}
		}
		return isMutualFundExists;

	}

	public String getQuantityForFund(String fund) {
		By quantity = By.xpath("//td[contains(text(),'" + fund + "')]//following-sibling::td//following-sibling::td");
		isDisplayed(costBasisSummaryForm, 3);
		return getText(quantity, 5);
	}

	public void navigateToMaxitVBS() {
		click(maxitVBS, 5);
	}

	public void navigateToMaxitMutualFund() {
		click(maxitMutualFund, 5);
	}

	public String getQuantityForVastFund(String vastAccountNumber) {
		By quantity = By
				.xpath("//span[contains(text(),'" + vastAccountNumber + "')]//ancestor::td//following-sibling::td");
		return getText(quantity, 5);
	}

}
