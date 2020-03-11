package com.xyz.retail.cucumber.stepdefs;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;

import com.vanguard.cucumber.selenium.hooks.CucumberTestSetup;
import com.vanguard.retail.cucumber.helpers.CostBasisCPTDataHelper;
import com.vanguard.retail.cucumber.support.CostBasisUserInterface;
import com.vanguard.retail.data.factory.ClientTestData;
import com.vanguard.retail.data.factory.MultiDayData;
import com.vanguard.selenium.inner.core.utils.LoggingUtility;
import com.vanguard.selenium.inner.environments.EnvironmentConfiguration;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class VerificationStepDefs {

	@Autowired
	CostBasisUserInterface costBasisUserInterface;
	@Autowired
	private ClientTestData clientTestData;
	@Autowired
	CostBasisCPTDataHelper costBasisCPTDataHelper;
	@Autowired
	CucumberTestSetup cucumberTestSetup;

	MultiDayData multiDayData;

	@Given("^verify \"([^\"]*)\" is already selected in changecostbasis page$")
	public void verifyisalreadyselectedinchangecostbasispage(String fromCBmethod) {
		CostBasisStepDefs.initialCBMethod = fromCBmethod;
		// costBasisUserInterface.clickViewChangeCBMethodLink();

		CostBasisStepDefs.accountnum = clientTestData.getClientType().getAccountNumber();
		costBasisUserInterface.clickChangeCostbasisMethodslink(CostBasisStepDefs.accountnum);
		CostBasisStepDefs.fund = clientTestData.getClientType().getFundName();
		costBasisUserInterface.verifySelectedCBMethodForAFund(CostBasisStepDefs.initialCBMethod,
				CostBasisStepDefs.accountnum, CostBasisStepDefs.fund);
	}

	@Given("^verify \"([^\"]*)\" is already selected in changecostbasispage$")
	public void verifyisalreadyselectedinchangecostbasispageGiftedShares(String fromCBmethod) {
		CostBasisStepDefs.targetCBmethod = fromCBmethod;
		CostBasisStepDefs.accountnum = clientTestData.getClientType().getAccountNumber();
		CostBasisStepDefs.fund = clientTestData.getClientType().getFundName();
		costBasisUserInterface.accountSelection(CostBasisStepDefs.accountnum);
		costBasisUserInterface.clickViewChangeCBMethodLink();
		costBasisUserInterface.verifyCBForSingleFundInCBMethodsPage(CostBasisStepDefs.targetCBmethod,
				CostBasisStepDefs.accountnum, CostBasisStepDefs.fund);
		costBasisUserInterface.cancelChangeCostBasisMethodFromChangeCostBasisPage();
		costBasisUserInterface.navigateToCostBasisPage();
		// costBasisUserInterface.selectAccountFromDropDownInCostbasisSummaryPage();
	}

	@Then("^I should see the cost basis method as \"([^\"]*)\" on cost basis methods page$")
	public void ishouldseethecostbasismethodasoncostbasismethodspage(String cbmethod) throws Throwable {
		costBasisUserInterface.verifyCBMethodForSingleFundInReviewConfirmPage(CostBasisStepDefs.targetCBmethod,
				CostBasisStepDefs.fund);
		costBasisUserInterface.clickMyAccounts();
		costBasisUserInterface.navigateToAccountMaintenanace();
		// costBasisUserInterface.clickCostBasisMethodPage();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		costBasisUserInterface.verifyCBForSingleFundInCBMethodsPage(CostBasisStepDefs.targetCBmethod,
				CostBasisStepDefs.accountnum, CostBasisStepDefs.fund);
		costBasisUserInterface.revertCBMethodForSingleFund(CostBasisStepDefs.initialCBMethod,
				CostBasisStepDefs.accountnum, CostBasisStepDefs.fund);
	}

	@Then("^I should be in Sell Options page$")
	public void ishouldbeinSellOptionspage() throws Throwable {
		costBasisUserInterface.isSellOptionsPagePresent();
	}

	@Then("^I should be in Buy Options page$")
	public void ishouldbeinBuyOptionspage() throws Throwable {
		costBasisUserInterface.isBuyOptionsPagePresent();
	}

	@Then("^I should be in Sell ETFs or stocks page$")
	public void ishouldbeinSellETFpage() throws Throwable {
		costBasisUserInterface.verifySellETForStockPage();
	}

	@Then("^I should be in Exchange vanguard funds page$")
	public void ishouldbeinExchangevanguardfundspage() throws Throwable {
		costBasisUserInterface.isExchangeVGFundsPagePresent();

	}

	@Then("^I should be in sell vanguard funds page$")
	public void ishouldbeinsellvanguardfundspage() throws Throwable {
		costBasisUserInterface.isSellVGFundsPagePresent();
	}

	@Then("^I should be in Trade non-Vanguard funds via FundAccess$")
	public void iShouldBeInExchangeNonVanguardMutulFundsPage() throws Throwable {
		costBasisUserInterface.isCurrentlyLoaded();
	}

	@Then("^I should be in Change cost basis methods page$")
	public void ishouldbeinChangecostbasismethodspage() throws Throwable {
		costBasisUserInterface.verifyChangecbMethodsPage();
	}

	@Then("^I should be in Sell non-vanguard funds page$")
	public void IshouldbeinSellnonvanguardfundspage() {
		costBasisUserInterface.isSellNonVGFundsPagePresent();
	}

	@Then("^I verify default costbasis configured as \"([^\"]*)\"$")
	public void iVerifyDefaultCostbasisConfiguredAs(String cbmethod) throws Throwable {
		CostBasisStepDefs.accountnum = clientTestData.getClientType().getAccountNumber();
		costBasisUserInterface.changeDefaultCBForAllMutualFunds(CostBasisStepDefs.accountnum, cbmethod);
	}

	@Then("^I should be in trade an etf or stock page$")
	public void ishouldbeintradeanetforstockpage() throws Throwable {
		costBasisUserInterface.verifyTradeETForStockPage();
	}

	@Then("^They verify the default of current year to date$")
	public void theyverifythedefaultofcurrentyeartodate() throws Throwable {
		costBasisUserInterface.verifyDefaultOfCurrentYearToDate();
	}

	@Then("^They verify the correct data populates in the correct columns$")
	public void theyverifythecorrectdatapopulatesinthecorrectcolumns() throws Throwable {
		costBasisUserInterface.verifyCorrectDataPopulatesInTheCorrectColumns();
	}

	@Then("^I should be in trade non vanguard funds via fundAccess page$")
	public void ishouldbeintradenonvanguardfundsviafundAccesspage() throws Throwable {
		costBasisUserInterface.isCurrentlyLoaded();
	}

	@Then("^I should see the cost basis method as \"([^\"]*)\" for all funds$")
	public void ishouldseethecostbasismethodasforallfunds(String cbmethod) throws Throwable {
		costBasisUserInterface.verifyInAccountmaintainance(CostBasisStepDefs.accountnum, cbmethod);
		LoggingUtility.logInfo("TC is passed finally");
		LoggingUtility.logInfo("Reverting Back to :" + CostBasisStepDefs.initialCBMethod);
		costBasisUserInterface.revertbackToInitial(CostBasisStepDefs.accountnum, CostBasisStepDefs.initialCBMethod);
	}

	@Then("^I should be in bonds and cds trading page$")
	public void ishouldbeinbondsandcdstradingpage() throws Throwable {
		costBasisUserInterface.viewAndTradeBondCdsIsCurrentlyLoaded();
	}

	@Then("^I should be in Buy Vanguard mutual fund page$")
	public void ishouldbeinBuyVanguardmutualfundpage() throws Throwable {
		costBasisUserInterface.isBuyVGFundsPagePresent();
	}

	@Then("^I should be in buy VMF page$")
	public void ishouldbeinbuyVMFpage() throws Throwable {
		costBasisUserInterface.isBuyVGFundsPagePresent();
	}

	@Then("^I should see cost basis updated to \"([^\"]*)\" in review and submit page$")
	public void ishouldseecostbasisupdatedtoinreviewadnsubmitpage(String costBasis) throws Throwable {
		costBasisUserInterface.verifyCostBasis(costBasis);
		costBasisUserInterface.clickreviewButton();
		if (costBasis.equalsIgnoreCase("SpecID")) {
			costBasisUserInterface.clickContinueShares();
			// costBasisUserInterface.clickContinueButton();
		}
		costBasisUserInterface.verifyCostBasisInReviewConfirmPage(costBasis);
	}

	@Then("^I should see cost basis as \"([^\"]*)\"$")
	public void ishouldseecostbasisas(String costBasis) throws Throwable {
		costBasisUserInterface.verifyCostBasis(costBasis);
	}

	@Then("^I should see cost basis updated to \"([^\"]*)\" in confirmation page$")
	public void ishouldseecostbasisupdatedtoinOrderstatuspage(String costBasis) throws Throwable {
		costBasisUserInterface.verifyCostBasisInReviewConfirmPage(costBasis);
	}

	@Then("^They select Show Details link to verify the date and number of shares matches Transaction History page$")
	public void theyselectShowDetailslinktoverifythedateandnumberofsharesmatchesTransactionHistorypage()
			throws Throwable {
		costBasisUserInterface.getShowDetailsDataInCostBasisSummaryPage();
		costBasisUserInterface.navigateToTransactionHistoryPage();
		costBasisUserInterface.selectAccountFromDropDownInTransactionHistoryPage();

	}

	@Then("^They verify the Mutual Fund with no Cost Basis selected is not showing on Gifted Shares tab$")
	public void theyverifytheMutualFundwithnoCostBasisselectedisnotshowingonGiftedSharestab() throws Throwable {
		costBasisUserInterface.verifyProvidedMutualFundDoesNotExistsInGiftedSharesTab();
	}

	@Given("^pre-check cost basis set up on the fund in TA is SPEC id$")
	public void preCheckCostBasisSetUpOnTheFundInTAIsSPECId() throws Throwable {
		costBasisUserInterface.navigateToAccountMaintenanace();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		costBasisUserInterface.verifyCBForSingleFundInCBMethodsPage("SpecID", costBasisCPTDataHelper.getFromAccount(),
				costBasisCPTDataHelper.getFromFund());
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.saveCurrentQuantityOfSharesForToFundIntoExcel();
	}

	@Given("^pre-check cost basis set up on the fund in VBA is Average cost method$")
	public void preCheckCostBasisSetUpOnTheFundInVBAIsAverageCostMethod() throws Throwable {
		costBasisUserInterface.navigateToAccountMaintenanace();
		costBasisUserInterface.navigateToCostBasisMethodPage();
		costBasisUserInterface.verifyCBForSingleFundInCBMethodsPage("AvgCost", costBasisCPTDataHelper.getFromAccount(),
				costBasisCPTDataHelper.getFromFund());
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.saveCurrentQuantityOfSharesForToFundIntoExcel();
	}

	@Then("^they should receive confirmation for the exchange transaction$")
	public void theyShouldReceiveConfirmationForTheExchangeTransaction() throws Throwable {
		costBasisUserInterface.verifyConfirmationNumberInExchangeSummaryPage();
		costBasisUserInterface.verifyDetailsInConfirmationPage();
		costBasisUserInterface.saveBrokerageAccountAndVastAccountForTAToVBATransferIntoExcel();
		costBasisUserInterface.navigateToPendingActivityThroughGlobalHeader();
		costBasisUserInterface.saveZNumberForBrokerageAccount(costBasisCPTDataHelper.getToAccount(),
				costBasisCPTDataHelper.getToFund());
	}

	@Then("^COO application should be launched$")
	public void cooApplicationShouldBeLaunched() throws Throwable {
		costBasisUserInterface.switchToWindow("Change Of Ownership");
	}

	@Then("^they should receive confirmation for the change of ownership$")
	public void theyShouldReceiveConfirmationForTheChangeOfOwnership() throws Throwable {
		costBasisUserInterface.verifyConfirmationForCOOTransaction();
		costBasisUserInterface.verifyDetailsInCOOConfirmationPage();
		costBasisUserInterface.saveBrokerageAccountAndVastAccountForCOOIntoExcel();
		costBasisUserInterface.switchToWindow("Balances and holdings");
		costBasisUserInterface.navigateToPendingActivityThroughGlobalHeader();
		costBasisUserInterface.saveZNumberForBrokerageAccount(costBasisCPTDataHelper.getToAccount(),
				costBasisCPTDataHelper.getToFund());
	}

	@Then("^they should receive Confirmation for the exchange transaction$")
	public void theyshouldReceiveConfirmationForTheExchangeTransaction() throws Throwable {
		costBasisUserInterface.verifyConfirmationNumberInExchangeSummaryPage();
		costBasisUserInterface.verifyDetailsInConfirmationPage();
		costBasisUserInterface.saveBrokerageAccountAndVastAccountForVBAToTATransferIntoExcel();
		cucumberTestSetup.driver().quit();
		DesiredCapabilities des = new DesiredCapabilities();
		EnvironmentConfiguration environmentConfig = new EnvironmentConfiguration(des);
		cucumberTestSetup.setup(environmentConfig);
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
		costBasisUserInterface.navigateToPendingActivityThroughGlobalHeader();
		costBasisUserInterface.saveZNumberForBrokerageAccount(costBasisCPTDataHelper.getFromAccount(),
				costBasisCPTDataHelper.getFromFund());
	}

	@Then("^they verify the details of the transaction for TA account$")
	public void theyVerifyTheDetailsOfTheTransactionForTAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		String vastAccountNumber = multiDayData.getVastAccountNumber();
		int index = vastAccountNumber.indexOf("-");
		String vastAccountNumberForMaxit = vastAccountNumber.substring(index + 1).trim()
				.concat(vastAccountNumber.substring(0, index).trim());
		costBasisUserInterface.searchAccountInRAD(vastAccountNumberForMaxit);
		costBasisUserInterface.verifyTransactionDetailsForTA(multiDayData);
	}

	@Then("^they verify the details of the transaction for VBA account$")
	public void theyVerifyTheDetailsOfTheTransactionForVBAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		costBasisUserInterface.searchAccountInRAD(multiDayData.getBrokerageAccountNumber());
		costBasisUserInterface.verifyTransactionDetailsForVBA(multiDayData);
	}

	@Then("^they verify the details of the CPT transaction for TA account$")
	public void theyVerifyTheDetailsOfTheCPTTransactionForTAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		String vastAccountNumber = multiDayData.getVastAccountNumber();
		int index = vastAccountNumber.indexOf("-");
		String vastAccountNumberForMaxit = vastAccountNumber.substring(index + 1).trim()
				.concat(vastAccountNumber.substring(0, index).trim());
		costBasisUserInterface.searchAccountInRAD(vastAccountNumberForMaxit);
		costBasisUserInterface.verifyTransactionDetailsForTAForAVBAToTATransfer(multiDayData);
	}

	@Then("^they verify the details of the CPT transaction for VBA account$")
	public void theyVerifyTheDetailsOfTheCPTTransactionForVBAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		costBasisUserInterface.searchAccountInRAD(multiDayData.getBrokerageAccountNumber());
		costBasisUserInterface.verifyTransactionDetailsForVBAForAVBAToTATransfer(multiDayData);
	}

	@Then("^they verify the details of the COO transaction for TA account$")
	public void theyVerifyTheDetailsOfTheCOOTransactionForTAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		String vastAccountNumber = multiDayData.getVastAccountNumber();
		int index = vastAccountNumber.indexOf("-");
		String vastAccountNumberForMaxit = vastAccountNumber.substring(index + 1).trim()
				.concat(vastAccountNumber.substring(0, index).trim());
		costBasisUserInterface.searchAccountInRAD(vastAccountNumberForMaxit);
		costBasisUserInterface.verifyTransactionDetailsForTA(multiDayData);
	}

	@Then("^they verify the details of the COO transaction for VBA account$")
	public void theyVerifyTheDetailsOfTheCOOTransactionForVBAAccount() throws Throwable {
		multiDayData = new MultiDayData(
				costBasisUserInterface.getMultidayDataFromExcelSheet(costBasisCPTDataHelper.getPrimaryKey()));
		costBasisUserInterface.searchAccountInRAD(multiDayData.getBrokerageAccountNumber());
		costBasisUserInterface.verifyTransactionDetailsForVBA(multiDayData);
	}

	@Then("^they verify lot information mathces with that of Day1$")
	public void theyVerifyLotInformation() throws Throwable {
		costBasisUserInterface.verifyLotInformationInMaxitLedger();
	}

	@Then("^they verify the lot information for VBA in UNREALIZED GAIN/LOSS tab$")
	public void theyVerifyTheLotInformationForVBAInUNREALIZEDGAINLOSSTab() throws Throwable {
		costBasisUserInterface.verifyShareQuantityForVBA();
	}

	@Then("^they verify the lot information for TA in UNREALIZED GAIN/LOSS tab$")
	public void theyVerifyTheLotInformationForTAInUNREALIZEDGAINLOSSTab() throws Throwable {
		costBasisUserInterface.verifyShareQuantityForTA();
	}
}
