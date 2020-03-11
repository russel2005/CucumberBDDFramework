package com.xyz.retail.pageobjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.xyz.retail.tools.CommonMethods;
import com.xyz.selenium.inner.core.pages.VanguardBasePageImpl;
import com.xyz.selenium.inner.core.utils.LoggingUtility;
import com.xyz.selenium.inner.core.utils.SeleniumWaitHelper;


public class CostBasisPage extends VanguardBasePageImpl {

	By selectaccount = By.xpath("//span[contains(@id,'cbaPortfolioSummary:cbAccountDropDown_textCont')]");

	By accountoptions = By.xpath("//tr/td[starts-with(@id,'cbaPortfolioSummary:cbAccountDropDown:')]");

	By myaccountsbar = By.xpath("//a[contains(@class,'vgc-horizNavBarTab') and span[text()='My Accounts']]");

	By costbasis = By.xpath("//div[@class='vgc-subSiloSection']//a[contains(@href,'CostBasis')]/span");

	By balanceandholdinglink = By.xpath("//li/a/span[text()='Balances & holdings']");

	CommonMethods commonMethods = new CommonMethods(driver);

	By costBasisResourceCenterLink = By.id("cbaPortfolioSummary:cbResourceCenterItem");

	By personalPerformanceLink = By.id("cbaPortfolioSummary:performanceItem");

	By taxIncomeLink = By.id("cbaPortfolioSummary:TaxesIncomeItem");

	By viewChangeCostBasis = By.xpath("//a[contains(text(),'View/Change cost basis method')]");

	By changecbMethodLink = By.xpath("//a[contains(text(),'View/Change cost basis method')]");

	By unrealizedGainsLossesTab = By
			.xpath("//li[contains(@class,'current')]/a/span[text()=' Unrealized gains & losses']");

	List<String> TransactionHistoryDetails = new ArrayList<String>();

	public CostBasisPage(WebDriver driver) {
		super(driver);
	}

	public void accountDropdownSelection() {

		if (!isDisplayed(selectaccount, 30)) {
			throw new ElementNotVisibleException("Drop down not available");
		}
		SeleniumWaitHelper.pause(5);
		click(selectaccount, 30);
	}

	/**
	 * US051729 Mar 01, 2016
	 * 
	 * @param account
	 *            This method is to select specific account in Cost Basis
	 *            Summary page
	 */
	public void accountSelection(String account) {
		SeleniumWaitHelper.pause(5);
		accountDropdownSelection();
		By acnt;

		// SeleniumWaitHelper.pause(5);
		if (account.contains("ï¿½")) {
			String accountArray[] = account.split("ï¿½");
			acnt = By.xpath(
					"//td[contains(text(),'" + accountArray[0] + "') and contains(text(),'" + accountArray[1] + "')]");
			if (!isDisplayed(acnt, 30)) {
				throw new ElementNotVisibleException("Account: " + account + " not found");
			}
		} else {
			acnt = By.xpath("//td[contains(text(),'" + account + "')]");
			SeleniumWaitHelper.pause(05);
			if (!isDisplayed(acnt, 30)) {
				throw new ElementNotVisibleException("Account: " + account + " not found");
			}
		}
		click(acnt, 30);
		SeleniumWaitHelper.pause(45);

	}

	/**
	 * US051725 May 10, 2016
	 * 
	 * To check whether account selection drop down is displayed once navigating
	 * to cost basis screen
	 */
	public boolean accountSelectionDropdownVisible() {

		if (isDisplayed(selectaccount, 30))
			return true;
		return false;

	}

	/**
	 * US051729 Mar 02, 2016
	 * 
	 * @param fund
	 * @param transcationType
	 *            This method is to click Buy or sell or Exchange link Exch for
	 *            Exchange, Sell for Sell, Buy for Buy
	 */
	public void clickBuySellExchangeLink(String fund, String transcationType) {

		By transactionType = By.xpath("//td[text()='" + fund + "']/..//a[contains(text(),'" + transcationType + "')]");
		if (!isDisplayed(transactionType, 30)) {
			throw new ElementNotVisibleException(transcationType + " link not available for fund/Option: " + fund);
		}

		click(transactionType, 30);
		SeleniumWaitHelper.pause(5);

	}

	/**
	 * US051729 May 11, 2016
	 * 
	 * @param option
	 * @param transcationType
	 *            Added method to click Buy/Sell in cost basis summary page for
	 *            an option
	 */
	public void clickBuySellExchangeLinkForAnOption(String option, String transcationType) {

		By transactionType = By.xpath("//td[contains(text(),'" + option
				+ "')]/../td[contains(text(),'CALL') or contains(text(),'PUT')]/..//a[contains(text(),'"
				+ transcationType + "')]");
		if (!isDisplayed(transactionType, 30)) {
			throw new ElementNotVisibleException(transcationType + " link not available for fund/Option: " + option);
		}
		click(transactionType, 30);

	}

	/**
	 * 
	 * US056483 Feb 15, 2017 splitted single method into three methods. Once the
	 * required account is selected,then Unrealized gains & losses tab is
	 * displayed
	 */
	public boolean isUnrealizedGainsAndLossesTabDisplayed() {
		SeleniumWaitHelper.pause(10);
		By unrealizedGainandloss = By.xpath("//a/span[text()=' Unrealized gains & losses']");
		SeleniumWaitHelper.pause(10);
		if (isDisplayed(unrealizedGainandloss, 30))
			return true;
		return false;

	}

	/**
	 * US056483 Feb 15, 2017 Once the required account is selected, this method
	 * is to verify losses,Realized gains tab is displayed.
	 */
	public boolean isRealizedGainsLossesTabDisplayed() {
		SeleniumWaitHelper.pause(10);
		By realizedGainandloss = By.xpath("//a/span[text()=' Realized gains & losses']");
		if (isDisplayed(realizedGainandloss, 30))
			return true;
		return false;
	}

	/**
	 * US056483 Feb 15, 2017 Once the required account is selected, this method
	 * is to verify Gifted shares tab is displayed.
	 */
	public boolean isGiftedSharesTabDisplayed() {
		SeleniumWaitHelper.pause(10);
		By giftedShares = By.xpath("//a/span[text()=' Gifted shares']");
		if (isDisplayed(giftedShares, 30))
			return true;
		return false;
	}

	/**
	 * US051729 Mar 01, 2016
	 * 
	 * This method is to verify whether Unrealized gains & losses tab is
	 * displayed by default
	 */
	public boolean isDefaultTab() {
		SeleniumWaitHelper.pause(8);

		if (isDisplayed(unrealizedGainsLossesTab, 30))
			return true;
		return false;

	}

	/**
	 * US051724 Mar 11, 2016
	 * 
	 * @return To get previous date to verify column name -
	 *         "Market Value as on 'previous date'".
	 */
	public String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calender = Calendar.getInstance();
		calender.get(Calendar.DAY_OF_WEEK);
		if (calender.get(Calendar.DAY_OF_WEEK) == 1) {
			calender.add(Calendar.DATE, -2);
		} else if (calender.get(Calendar.DAY_OF_WEEK) == 2) {
			calender.add(Calendar.DATE, -3);
		} else {
			calender.add(Calendar.DATE, -1);
		}
		return (df.format(calender.getTime()));
	}

	/**
	 * US051729 Feb 11, 2016
	 * 
	 * @param columnnames
	 *            To verify column names in Unrealized gains & losses table.
	 */
	public void verifyColumnName(List<String> columnnames) {
		List<WebElement> columns = driver
				.findElements(By.xpath("//th/span/span/a[contains(@id,'unrealizedTabForm:infoBox_MethodColumnHead')]"));
		try {

			for (int i = 0; i < columns.size(); i++) {
				if (columns.get(i).getText().startsWith("Market")) {

					columns.get(i).getText().contains(columnnames + " " + getDate());
					LoggingUtility.logInfo("Column " + columns.get(i).getText() + " is displayed");
				} else {
					columnnames.contains(columns.get(i).getText());
					LoggingUtility.logInfo("Column " + columns.get(i).getText() + " is displayed");
				}
			}

		} catch (Exception e) {
			/*
			 * commonMethods .exceptionHandler(
			 * "Given columns are missing in Unrealized gains & losses tab",
			 * exception);
			 */
			throw new NoSuchElementException("Given columns are missing in Unrealized gains & losses tab");
		}
	}

	// To split fund name from fund account number in cost basis screen.
	public static int stringSplit1(String fund) {
		int i;
		for (i = 0; i < fund.length(); i++) {
			if (fund.charAt(i) >= 48 && fund.charAt(i) <= 57) {

				break;
			}
		}
		return i;
	}

	// To store the fund order in string array.
	public String[] costBasisFundOrder() {
		String[] cbfundname = null;
		List<WebElement> cbfundorder = driver.findElements(By.xpath(
				"//div/h1[contains(@class,'option3a')]/following-sibling::span//tr[@onmouseout='_doRollover(this, false, true)' and @index!=0]/td[2]"));
		try {
			cbfundname = new String[cbfundorder.size()];
		} catch (Exception e) {
			commonMethods.exceptionHandler("Dint find the funds in cost basis page", e);
		}
		for (int i = 0; i < cbfundorder.size(); i++) {
			int endindex = stringSplit1(cbfundorder.get(i).getText());
			cbfundname[i] = cbfundorder.get(i).getText().substring(0, endindex).trim();
		}
		return cbfundname;
	}

	// To compare the fund order in two screens - Cost basis and Balance and
	// Holdings screen
	public boolean compareStringArray(String[] cb, String[] bh) {
		for (int i = 0; i < bh.length; i++) {
			if (!(cb[i].trim().equals(bh[i].trim()))) {
				LoggingUtility.logInfo("Funds are not in order");
				return false;
			} else {
				LoggingUtility.logInfo("Funds are in order");
			}
		}
		return true;

	}

	// To navigate to balance and holdings screen
	public void navigatetobalanceandholdings() {

		SeleniumWaitHelper.pause(5);
		Actions action = new Actions(driver);
		action.moveToElement(findElement(myaccountsbar)).click().perform();
		if (!isDisplayed(balanceandholdinglink, 30)) {
			throw new ElementNotVisibleException("Failed to navigate to Balances & Holdings page");
		}
		click(balanceandholdinglink, 30);
		SeleniumWaitHelper.pause(5);

	}

	// To retrieve the fund order in Balance and holdings page and passing both
	// string array to compare.
	public boolean verifyorder(String[] funds, String account) {

		List<WebElement> bhfundorder = driver.findElements(By.xpath("//td[contains(text(),'" + account
				+ "')]/ancestor::span[@class='comp-DataTable']/../../following-sibling::span//span[@class='comp-DataTable']//tr[contains(@onmouseout,'_doRollover')]/td[2]"));
		/*
		 * WebElement selectedaccount = driver .findElement(By .xpath(
		 * "//table[contains(@id,'BHForm2:accountID:')]//td[contains(text(),'" +
		 * account + "')]"));
		 */
		By selectedaccount = By
				.xpath("//table[contains(@id,'BHForm2:accountID:')]//td[contains(text(),'" + account + "')]");
		String[] bhfundname = new String[bhfundorder.size()];

		for (int i = 0; i < bhfundorder.size(); i++) {
			bhfundname[i] = bhfundorder.get(i).getText().trim();
		}
		if (isDisplayed(selectedaccount, 30)) {
			if (compareStringArray(funds, bhfundname))
				return true;

		}
		return false;

	}

	// To navigate to cost basis screen
	public void costbasisNavigation() {

		Actions action = new Actions(driver);
		SeleniumWaitHelper.pause(5);
		action.moveToElement(findElement(myaccountsbar)).click().perform();
		if (!isDisplayed(costbasis, 30)) {
			throw new ElementNotVisibleException("Failed to navigate to cost basis page");
		}
		click(costbasis, 30);
		SeleniumWaitHelper.pause(2);

	}

	// To verify Buy link for vanguard mutual fund is displayed and takes user
	// to Buy funds page once clicked.
	public void clickBuyLink(String fundacctnumber) {
		SeleniumWaitHelper.pause(5);

		By buyLink = By.xpath("//td[text() = '" + fundacctnumber
				+ "']/ancestor::tr/td//p[contains(@id,'LINKBARID')]//a[contains(@href,'BUY')]");
		if (!isDisplayed(buyLink, 30)) {
			if (!isDisplayed(buyLink, 30))
				throw new ElementNotVisibleException("Failed to click Buy link for fund: " + fundacctnumber);
		}

		click(buyLink, 30);
		SeleniumWaitHelper.pause(5);

	}

	public boolean isCurrentlyLoaded() {
		return (selectaccount != null) && (isDisplayed(selectaccount, 30));
	}

	public boolean isCostBasisResourceCenterLinkPresent() {

		return isDisplayed(costBasisResourceCenterLink, 30);

	}

	public boolean isPersonalPerformanceLinkPresent() {

		return isDisplayed(personalPerformanceLink, 30);

	}

	public boolean isTaxIncomeLinkLinkPresent() {

		return isDisplayed(taxIncomeLink, 30);
	}

	public boolean isViewChangeCostBasisMethodLinkLinkPresent() {

		return isDisplayed(viewChangeCostBasis, 30);

	}

	public boolean clickViewChangeCBMethodLink() {
		if (isDisplayed(changecbMethodLink, 30)) {
			click(changecbMethodLink, 30);
			return true;

		}
		return false;
	}

	public boolean clickChangeCostbasisMethodslink(String accountNumber) {
		By changeCostbasisMethodsLink = By.xpath("//span[contains(text(),'" + accountNumber
				+ "')]//..//a[contains(text(),'Change cost basis methods')]");

		if (isDisplayed(changeCostbasisMethodsLink, 30)) {
			click(changeCostbasisMethodsLink, 30);
			return true;

		}
		return false;

	}

	/*
	 * public void clickViewCostBasisMethodLink() {
	 * 
	 * click(ViewCostBasisMethods, 20);
	 * 
	 * }
	 */

}
