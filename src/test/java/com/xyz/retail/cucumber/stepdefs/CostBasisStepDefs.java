package com.xyz.retail.cucumber.stepdefs;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vanguard.cucumber.selenium.hooks.CucumberTestSetup;
import com.vanguard.retail.cucumber.support.CommonUserInterface;
import com.vanguard.retail.cucumber.support.CostBasisUserInterface;
import com.vanguard.retail.data.factory.ClientDataType;
import com.vanguard.retail.data.factory.ClientTestData;
import com.vanguard.retail.domainobjects.TradeETForStock;
import com.vanguard.retail.pageobjects.ChangeOfOwnershipPage;
import com.vanguard.selenium.inner.core.utils.LoggingUtility;
import com.vanguard.selenium.inner.core.utils.SeleniumWaitHelper;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class CostBasisStepDefs {

	@Autowired
	CostBasisUserInterface costBasisUserInterface;
	@Autowired
	public CucumberTestSetup testSetup;
	@Autowired
	private ClientTestData clientTestData;

	static String accountnum;
	static String targetCBmethod;
	static String initialCBMethod;
	static String fund;
	public String changedCBMethod;
	public static Scenario stepInScenario;
	public String accountNumber;
	public String costbasisMethod;

	/*
	 * @Before public void before(Scenario scenario) { stepInScenario =
	 * scenario; LoggingUtility.logInfo("Executing Scenario: " +
	 * scenario.getName().toUpperCase()); }
	 */

	@Given("^I am in cost basis page$")
	public void iamincostbasispage() throws Throwable {
		costBasisUserInterface.navigateToCostBasisPage();
	}

	@When("^I Buy a vanguard ETF \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iBuyavanguardETFforaccount(String tradeeftName, String LegacyBrokerageAccount) throws Throwable {
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Buy");
	}

	@When("^I edit cost basis to \"([^\"]*)\"$")
	public void ieditcostbasisto(String costBasis) throws Throwable {
		changedCBMethod = costBasis;
		SeleniumWaitHelper.pause(8);
		costBasisUserInterface.clickOrderStatusLink();
		costBasisUserInterface.clickEditCostBasisLink();
		costBasisUserInterface.selectCostBasis(costBasis);
	}

	@When("^I modify cost basis to \"([^\"]*)\"$")
	public void Imodifycostbasisto(String costBasis) {
		costBasisUserInterface.selectCostBasis(costBasis);
	}

	@When("^I re-submit the order$")
	public void iresubmittheorder() throws Throwable {
		costBasisUserInterface.clickreviewButton();
		costBasisUserInterface.submitOrder();
	}

	@Given("^I am in cost basis internal page$")
	public void iAmInCostBasisInternalPage() throws Throwable {
		costBasisUserInterface.navigateToCostBasis();
	}

	@Given("^I am in cost basis page via Balances & Holdings page for \"([^\"]*)\" account$")
	public void iamincostbasispageviabalancesholdingspagefroaccount(String accnt) throws Throwable {
		costBasisUserInterface.clickBalancesAndHoldingsPageExternally();
		costBasisUserInterface.clickCostBasisForAccount(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.linkVerificationInCostBasis();
	}

	@Given("^I am in cost basis page internally via Balances & Holdings page from \"([^\"]*)\" account$")
	public void iamincostbasispageinternallyviabalancesholdingspagefromaccount(String accnt) throws Throwable {
		costBasisUserInterface.navigateToBalancesHoldingsPage();
		costBasisUserInterface.clickCostBasisForAccount(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.linkVerificationInCostBasis();
	}

	@Given("^I am on cost basis methods page$")
	public void iamoncostbasismethodspage() throws Throwable {
		costBasisUserInterface.clickMyAccounts();
		costBasisUserInterface.navigateToAccountMaintenanace();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		// driver.navigate().refresh();
	}

	@When("^I change cost basis method from \"([^\"]*)\" to \"([^\"]*)\" for \"([^\"]*)\" from \"([^\"]*)\"$")
	public void ichangecostbasismethodtofor(String fromCBmethod, String tarCBmethod, String fundName, String accnt)
			throws Throwable {
		initialCBMethod = fromCBmethod;
		LoggingUtility.logInfo("Initial CB Method is :  " + initialCBMethod);
		targetCBmethod = tarCBmethod;
		accountnum = clientTestData.getClientType().getAccountNumber();
		fund = clientTestData.getClientType().getFundName();
		costBasisUserInterface.changeCBMethodForAFund(targetCBmethod, accountnum, fund);
		costBasisUserInterface.clickContinue();
		costBasisUserInterface.verifyCBMethodForSingleFundInReviewConfirmPage(targetCBmethod, fund);
	}

	@When("^I submit the change$")
	public void Isubmitthechange() {
		costBasisUserInterface.clickSubmitBtn();
	}

	@When("^I exchange non-vanguard fund \"([^\"]*)\" from account \"([^\"]*)\"$")
	public void iexchangeNonvanguardfundforaccount(String forFund, String account) throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Exch");
	}

	@When("^I Exchange vanguard fund \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iExchangevanguardfundforaccount(String forFund, String account) throws Throwable {
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Exch");
		// driver.navigate().refresh();
	}

	@When("^I sell vanguard mutual fund \"([^\"]*)\"$")
	public void isellvanguardmutualfund(String fund) throws Throwable {
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
	}

	@When("^I exchange vanguard mutual fund \"([^\"]*)\"$")
	public void iexchangevanguardmutualfund(String fund) throws Throwable {
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Exch");
	}

	@When("^I Sell vanguard fund \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iSellvanguardfundforaccount(String vanguardFund, String accountName) throws Throwable {
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
	}

	@When("^I sell vanguard ETF \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void isellvanguardETFforaccount(String fund, String accountNumber) throws Throwable {
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
	}

	@When("^I sell stock \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void isellstockforaccount(String stock, String accountNumber) throws Throwable {
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
	}

	@When("^I sell trade option \"([^\"]*)\"$")
	public void iselltradeoption(String option) throws Throwable {
		costBasisUserInterface.clickBuySellExchangeLinkForAnOption(clientTestData.getClientType().getFundName(),
				"Sell");
	}

	@When("^I buy trade option \"([^\"]*)\" from account \"([^\"]*)\"$")
	public void ibuytradeoptionfromaccount(String option, String accountNumber) throws Throwable {
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLinkForAnOption(clientTestData.getClientType().getFundName(), "Buy");
	}

	@When("^I Sell non vanguard fund \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void ISellnonvanguardfundforaccount(String fund, String account) {
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
	}

	@When("^I click View/change cost basis method link of \"([^\"]*)\" account$")
	public void iclickViewchangecostbasismethodlink(String accnt) throws Throwable {
		costBasisUserInterface.clickViewChangeCBMethodLink();
	}

	@Given("^I am in change cost basis methods page for joint account \"([^\"]*)\"$")
	public void iaminchangecostbasismethodspageforjointaccount(String acctnum) throws Throwable {
		accountnum = clientTestData.getClientType().getAccountNumber();
		costBasisUserInterface.navigateToAcctMaintainance();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		costBasisUserInterface.navigateToChangeCostBasisPage(accountnum);
	}

	@Given("^I am in change cost basis methods page for individual account \"([^\"]*)\" with \"([^\"]*)\"$")
	public void iaminchangecostbasismethodspageforindividualaccountwith(String acctname, String fundnum)
			throws Throwable {
		accountnum = clientTestData.getClientType().getAccountNumber();
		costBasisUserInterface.navigateToAccountMaintenanace();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		costBasisUserInterface.navigateToChangeCostBasisPage(accountnum);
	}

	@When("^I change cost Basis method from \"([^\"]*)\" to \"([^\"]*)\" for all funds$")
	public void ichangecostBasismethodfromtoforallfunds(String cbmethod1, String cbmethod2) throws Throwable {
		targetCBmethod = cbmethod2;
		initialCBMethod = cbmethod1;
		costBasisUserInterface.changeAllMutualFundsTo(accountnum, cbmethod2);
	}

	@When("^I submit the changes$")
	public void isubmitthechanges() throws Throwable {
		costBasisUserInterface.submitChanges(accountnum, targetCBmethod);
	}

	@When("^I Buy a Non vanguard Fund \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iBuyaNonvanguardFundforaccount(String nvFundName, String LegacyBrokerageAccount) throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Buy");
	}

	@When("^I exchange fund$")
	public void iexchangefundforTA() throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.linkVerificationInCostBasis();
	}

	@When("^I Buy a bond \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iBuyabondforaccount(String tradeBondName, String LegacyBrokerageAccount) throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Buy");
		SeleniumWaitHelper.pause(25);
	}

	@When("^I Sell a bond \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iSellabondforaccount(String tradeBondName, String LegacyBrokerageAccount) throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Sell");
		SeleniumWaitHelper.pause(25);
	}

	@When("^I Buy vanguard Mutual fund \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void iBuyvanguardMutualfundforaccount(String fund, String accountNumber) throws Throwable {
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Buy");
	}

	@When("^I buy vanguard VMF \"([^\"]*)\" for account \"([^\"]*)\"$")
	public void ibuyvanguardVMFforaccount(String forFund, String account) throws Throwable {
		costBasisUserInterface.accountSelectionDropdownVisible();
		costBasisUserInterface.accountSelection(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.isTabsDisplayed();
		costBasisUserInterface.isDefaultTab();
		costBasisUserInterface.clickBuySellExchangeLink(clientTestData.getClientType().getFundName(), "Buy");
	}

	@When("^I submit the order with \"([^\"]*)\" shares$")
	public void isubmittheorderwithshares(String sharesQty) throws Throwable {
		costBasisUserInterface.clickreviewButton();
		if (sharesQty != null && changedCBMethod.equalsIgnoreCase("SpecID")) {
			costBasisUserInterface.selectShares(clientTestData.getClientType().getNumofShares());
			costBasisUserInterface.clickContinueShares();
			// costBasisUserInterface.clickContinueButton();
		}
		costBasisUserInterface.submitOrder();
	}

	@When("^I edit cost basis for \"([^\"]*)\"$")
	public void Ieditcostbasisfor(String accnt) {
		costBasisUserInterface.navigateToOrderStatus();
		costBasisUserInterface.selectAccountNumberinOrderStatuspage(clientTestData.getClientType().getAccountNumber());
		costBasisUserInterface.clickEditCostBasisLink("Partial Execution");
	}

	@Given("^Order is in partially executed status$")
	public void Orderisinpartiallyexecutedstatus() throws Throwable {
		SeleniumWaitHelper.pause(10);
		costBasisUserInterface.clickOrderStatusLink();
		costBasisUserInterface.clickChangeLink();
		costBasisUserInterface.changeQuantity("104");
		costBasisUserInterface.clickReviewContinueButton();
		costBasisUserInterface.submitOrder();
		SeleniumWaitHelper.pause(10);
	}

	@When("^I edit cost basis$")
	public void ieditcostbasis() throws Throwable {
		SeleniumWaitHelper.pause(5);
		costBasisUserInterface.clickOrderStatusLink();
		costBasisUserInterface.clickEditCostBasisLink();
	}

	@Given("^I am in trade ETFs and Stocks page$")
	public void iamintradeETFsandStockspage() throws Throwable {
		costBasisUserInterface.navigateToKeyclientDataPage();
		costBasisUserInterface.gotobuysell();
		costBasisUserInterface.navigateLinksInBuySellPage("Trade stocks and listed securities");
	}

	@Given("^I am in Trade an ETF or stock page$")
	public void iamintradeanETFsorStockspage() throws Throwable {
		costBasisUserInterface.clickBuySellLink();
		costBasisUserInterface.clickTradeStocksLink();
	}

	@Given("^I have an ETF order with following data$")
	public void iHaveAnETFOrderWithFollowingData(List<TradeETForStock> tradeForStock) throws Throwable {
		Iterator<TradeETForStock> it = tradeForStock.iterator();
		TradeETForStock tradeETFforStock = new TradeETForStock();
		while (it.hasNext()) {
			tradeETFforStock = it.next();
			System.out.println("tradeETFforStock value is :" + tradeETFforStock);
			tradeETFforStock.setAccountName(clientTestData.getClientType().getAccountNumber());
			tradeETFforStock = costBasisUserInterface.fillTradeETForStocksData(tradeETFforStock);
			costBasisUserInterface.navigateToReviewSubmitPage();
			costBasisUserInterface.alertHandler();
			costBasisUserInterface.clickContinueButton();
			// editCostBasis.clickreviewButton();
			costBasisUserInterface.submitOrder();
		}
	}

	@Given("^I goto Trade Vanguard ETFs and non-Vanguard ETFs page$")
	public void igotoTradeVanguardETFsandnonVanguardETFspage() throws Throwable {
		costBasisUserInterface.gotobuysell();
		costBasisUserInterface.navigateLinksInBuySellPage("Trade Vanguard ETFs (and non-Vanguard ETFs)");
	}

	@Given("^Client logs in and selects Cost basis from My Accounts$")
	public void clientLogsInAndSelectsCostBasisFromMyAccounts() throws Throwable {
		clientTestData.setChannel("WEB");
		clientTestData.setClientType(ClientDataType.getClientInformationValidationType("VTA_Account_GiftedShares"));
		clientTestData.setUserID(clientTestData.getClientType().getUserName());
		CommonUserInterface commonMethods = new CommonUserInterface(testSetup.driver());
		commonMethods.setTestSetup(testSetup);
		commonMethods.setClientTestData(clientTestData);
		commonMethods.login();
		testSetup.driver().manage().window().maximize();
		costBasisUserInterface.navigateToCostBasisPage();
	}

	@Given("^Client logs in and selects Cost basis from My Accounts for a Mutal Fund$")
	public void clientLogsInAndSelectsCostBasisFromMyAccountsForAMutalFund() throws Throwable {
		clientTestData.setChannel("WEB");
		clientTestData.setClientType(ClientDataType
				.getClientInformationValidationType("VTA_Account_GiftedShares_NotSelectedCostBasisMethod"));
		clientTestData.setUserID(clientTestData.getClientType().getUserName());
		CommonUserInterface commonMethods = new CommonUserInterface(testSetup.driver());
		commonMethods.setTestSetup(testSetup);
		commonMethods.setClientTestData(clientTestData);
		commonMethods.login();
		testSetup.driver().manage().window().maximize();
		costBasisUserInterface.navigateToCostBasisPage();
	}

	@Given("^They verify Cost basis Summary page shows with all the valid links$")
	public void theyverifyCostbasisSummarypageshowswithallthevalidlinks() throws Throwable {
		costBasisUserInterface.verifyCostBasisSummaryPageShowsWithAllValidLinks();
	}

	@When("^They select the Gifted shares tab of the From account$")
	public void theyselecttheGiftedsharestaboftheFromaccount() throws Throwable {
		costBasisUserInterface.selectAccountFromDropDownInCostbasisSummaryPage();
		costBasisUserInterface.selectGiftedSharesTab();
	}

	@When("^they navigate to Exchange Vanguard funds page$")
	public void theyNavigateToExchangeVanguardFundsPage() throws Throwable {
		costBasisUserInterface.navigateToExchangeVGFundsPage();
	}

	@When("^process an exchange from a fund in TA to the same fund in VBA$")
	public void processAnExchangeFromAFundInTAToTheSameFundInVBA() throws Throwable {
		costBasisUserInterface.processExchangeTransaction();
		costBasisUserInterface.verifyDetailsInReviewSubmitPage();
		costBasisUserInterface.submitTheTransaction();
	}

	@When("^associate creates AWD work object for Change of Ownership$")
	public void associateCreatesAWDWorkObjectForChangeOfOwnership() throws Throwable {
		costBasisUserInterface.createAWDWorkObject();
	}

	@When("^selects line of business to perform share transfer$")
	public void selectsLineOfBusinessToPerformShareTransfer() throws Throwable {
		costBasisUserInterface.updateObjectDetails();
		costBasisUserInterface.clickTransact();
	}

	@When("^they choose to gift by SPEC id from TA to VBA of secondary client$")
	public void theyChooseToGiftBySPECIdFromTAToVBAOfSecondaryClient() throws Throwable {
		costBasisUserInterface.processCOOByGiftBySpecId();
		costBasisUserInterface.verifyDetailsInCOOReviewSubmitPage();
		costBasisUserInterface.submitCOOTransaction();
	}

	@When("^process an exchange from a fund in VBA to the same fund in TA$")
	public void processAnExchangeFromAFundInVBAToTheSameFundInTA() throws Throwable {
		costBasisUserInterface.processExchangeTransactionByShares();
		costBasisUserInterface.verifyDetailsInReviewSubmitPage();
		costBasisUserInterface.submitTheTransaction();
	}

	@When("^they navigate to Database Management Interface screen in MAXIT for TA$")
	public void theyNavigateToDatabaseManagementInterfaceScreenInMAXITForTA() throws Throwable {
		costBasisUserInterface.navigateToCostBasisWindow();
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.navigateToMaxitMutualFund();
		costBasisUserInterface.navigateToDatabaseManagementInterfaceScreenForTA();
	}

	@When("^they navigate to Database Management Interface screen in MAXIT for VBA$")
	public void theyNavigateToDatabaseManagementInterfaceScreenInMAXITForVBA() throws Throwable {
		costBasisUserInterface.navigateToCostBasisWindow();
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.navigateToMaxitVBS();
		costBasisUserInterface.navigateToDatabaseManagementInterfaceScreenForVBA();
	}

	@When("^they navigate to MAXIT mutual fund ledger screen$")
	public void theyNavigateToMAXITTALedgerScreen() throws Throwable {
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.navigateToMaxitMutualFund();
		costBasisUserInterface.searchForAccountAndFundInMaxitLedger("TA");
	}

	@When("^they navigate to MAXIT VBS ledger screen$")
	public void theyNavigateToMAXITVBSLedgerScreen() throws Throwable {
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.navigateToMaxitVBS();
		costBasisUserInterface.searchForAccountAndFundInMaxitLedger("VBA");
	}

	@When("^they navigate to Cost basis summary page$")
	public void theyNavigateToCostBasisSummaryPage() throws Throwable {
		costBasisUserInterface.navigateToCostBasisPage();
	}

}
