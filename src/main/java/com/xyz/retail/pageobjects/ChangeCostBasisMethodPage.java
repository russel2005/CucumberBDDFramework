package com.vanguard.retail.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.xyz.retail.tools.CommonMethods;
import com.xyz.selenium.inner.base.PageNavigationException;
import com.xyz.selenium.inner.core.pages.VanguardBasePageImpl;
import com.xyz.selenium.inner.core.utils.LoggingUtility;
import com.xyz.selenium.inner.core.utils.SeleniumWaitHelper;


public class ChangeCostBasisMethodPage extends VanguardBasePageImpl {

	WebDriverWait waitformedriver = new WebDriverWait(driver, 10);
	AccountMaintainencePage acctmtpageintrl = new AccountMaintainencePage(driver);
	MyHomePage myhomepage = new MyHomePage(driver);
	CommonMethods commonMethods = new CommonMethods(driver);

	// xpath for cost Basis Methods page header
	By costBasisHdr = By.xpath("//h1/span[contains(text(),'Cost basis methods')]");

	// xpath for change cost basis methods page header
	By changecostbasisHdr = By.xpath("//h1[contains(text(),'Change cost basis methods')]");

	// Change all mutual funds to link web element
	By changeAllMFTo = By.xpath("//a[contains(text(),'Change all mutual funds to ...')]");

	By specID = By.id("SpecIDItem");

	By hifo = By.id("HifoItem");

	By fifo = By.id("FifoItem");

	By avgCost = By.id("averageCostItem");

	By applyButton = By.id("CBAMChangeAllSelectMethodForm:changeAllYesInput");

	By continueButton = By.id("CostBasisAccountMaintChangeForm:fakeContinueButtonInput");

	By submitButton = By.id("CostBasisAccountMaintReviewForm:continueButtonInput");

	By changeCBPageHdr = By.xpath("//span/div/h1[contains(text(),'Change cost basis methods')]");

	By costLayercontinue = By.id("avgCostLayerForm:avgCostYesButtonInput");

	By costLayerHdr = By.xpath("//div[contains(text(),'Important information about changing cost basis methods')]");

	By costBasiscontinue = By.id("CostBasisAccountMaintChangeForm:fakeContinueButtonInput");

	By reviewSubmitHdr = By.xpath("//div/h1[contains(text(),'Review and submit')]");

	By confirmNum = By.id("CostBasisAccountMaintConfirmForm:confirmNumber");

	By drele = By.xpath("//div[@class='vg-SelOneMenuDropDownScroll']");

	By avgCostLayerContinueBtn = By.id("avgCostLayerForm:avgCostYesButtonInput");

	By reviewForm = By.id("CostBasisAccountMaintReviewForm");
	By cancelButton = By.id("CostBasisAccountMaintChangeForm:cancelButtonInput");
	By yesButton = By.id("cancelSureLayerForm:cancelYesButtonInput");

	public ChangeCostBasisMethodPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/**
	 * US051724 Mar 11, 2016
	 * 
	 * @param acctnum
	 *            This method is to navigate to Change Cost Basis Methods page
	 *            for given account number
	 */
	public boolean navigateToChangeCostBasisPage(String acctnum) {
		/*
		 * waitformedriver.until(ExpectedConditions.visibilityOf(findElement(
		 * costBasisHdr)));
		 */

		if (isDisplayed(costBasisHdr, 30)) {
			By changeCBMethodlink = By.xpath("//td/span[contains(text(),'" + acctnum + "')]"
					+ "/ancestor::td//a[contains(text(),'Change cost basis methods')]");
			if (isDisplayed(changeCBMethodlink, 30))
				click(changeCBMethodlink, 30);
			SeleniumWaitHelper.pause(3);
			return true;

		}
		return false;

	}

	/**
	 * US056483 May 23, 2017
	 * 
	 * @param expectedCB
	 * @param This
	 *            method is to verify default CB method is present for all
	 *            mutual funds or not
	 */
	public boolean verifyDefaultCBForAllMutualFunds(String cbmethod) {

		List<WebElement> cbMethodForAllMutualFunds = driver
				.findElements(By.xpath("//tr[@class='vg-SelOneMenuVisRow']"));

		for (WebElement element : cbMethodForAllMutualFunds) {
			if (getText(element).contains(cbmethod)) {

			} else
				return false;
		}

		return true;
	}

	/**
	 * US056483 May 23, 2017
	 * 
	 * @param expectedCB
	 * @param This
	 *            method is to revert to default CB method for all mutual funds
	 *            in Change CB Page
	 */
	public boolean revertbackToDefaultCBForAllMutualFunds(String accntNum, String cbmethod) {

		if ((changeAllMutualFundsTo(accntNum, cbmethod) && submitChanges(accntNum, cbmethod)))
			return true;
		else
			return false;

	}

	/**
	 * US051724 Mar 11, 2016
	 * 
	 * @param acctnum
	 * @param option
	 *            Changing cost basis method to all MUTUAL FUNDS
	 */
	public boolean changeAllMutualFundsTo(String acctnum, String option) {
		/*
		 * WebElement account = driver.findElement(By
		 * .xpath("//td/span[contains(text(),'" + acctnum + "')]")); WebElement
		 * changeAllLayerHdr = driver.findElement(By
		 * .xpath("//div[contains(text(),'" + acctnum + "')]"));
		 * waitformedriver.until(ExpectedConditions.visibilityOf(account));
		 */

		By accntNum = By.xpath("//td/span[contains(text(),'" + acctnum + "')]");
		if (isDisplayed(accntNum, 30)) {

			click(changeAllMFTo, 20);
			SeleniumWaitHelper.pause(7);
			if (isDisplayed(avgCost, 15)) {
				if ((getText(avgCost)).contains(option)) {
					click(avgCost, 10);
					SeleniumWaitHelper.pause(3);
				}
			}
			if (isDisplayed(fifo, 15)) {
				if ((getText(fifo)).contains(option)) {
					click(fifo, 10);
					SeleniumWaitHelper.pause(3);

				}
			}
			if (isDisplayed(hifo, 15)) {
				if ((getText(hifo)).contains(option)) {
					click(hifo, 10);
					SeleniumWaitHelper.pause(3);
				}
			}
			if (isDisplayed(specID, 15)) {
				if ((getText(specID)).contains(option)) {
					click(specID, 10);
					SeleniumWaitHelper.pause(3);
				}
			}
			SeleniumWaitHelper.pause(5);
			if (isDisplayed(applyButton, 30))
				click(applyButton, 20);
			SeleniumWaitHelper.pause(2);
			if (isDisplayed(continueButton, 20))
				click(continueButton, 10);
			SeleniumWaitHelper.pause(2);

			if (isDisplayed(avgCostLayerContinueBtn, 10)) {
				click(avgCostLayerContinueBtn, 10);
				return true;
			}
			return true;
		}
		return false;

	}

	/**
	 * US051724 Mar 11, 2016
	 * 
	 * @param accnum
	 * @param cbmethod
	 *            This method is to submit the changes in Change cost basis
	 *            methods page
	 */
	public boolean submitChanges(String accnum, String cbmethod) {
		waitformedriver.until(ExpectedConditions.visibilityOf(findElement(reviewSubmitHdr)));
		int cnt;
		int costBasisMethodsCnt = 0;

		if (isDisplayed(reviewSubmitHdr, 10)) {
			// getting row count for table with account name
			cnt = driver
					.findElements(
							By.xpath("//td/span[contains(text(),'" + accnum + "')]/ancestor::tr/following-sibling::tr"))
					.size();
			System.out.println("row count is:" + cnt);
			for (int i = 1; i <= cnt; i++) {
				// getting each row content and matching with cbmethod
				// passed.
				WebElement row = driver.findElement(By.xpath(
						"//td/span[contains(text(),'" + accnum + "')]/ancestor::tr/following-sibling::tr[" + i + "]"));
				System.out.println("row value is:" + row.getText());
				if ((row.getText()).contains(cbmethod)) {
					costBasisMethodsCnt = costBasisMethodsCnt + 1;
				}
			}
			// if cbmethod is present in all rows except first 2 header
			// rows(symbol,mutual funds) for VTA
			if (costBasisMethodsCnt == cnt - 2) {
				System.out.println("its changed for all funds for VTA with account num:" + accnum);
				click(submitButton, 10);
				LoggingUtility.logInfo("Confirmation Number is: " + getText(confirmNum));
				return true;
			}
			// if cbmethod is present in all rows except first 1 header
			// row(symbol) for TA
			if (costBasisMethodsCnt == cnt - 1) {
				System.out.println("its changed for all funds for TA with account name:" + accnum);
				click(submitButton, 10);
				LoggingUtility.logInfo("Confirmation Number is: " + getText(confirmNum));
				return true;
			}

		}
		return false;

	}

	/**
	 * US051724 Mar 1, 2016
	 * 
	 * @param accnum
	 * @param cbmthd
	 *            This method is to verify Cost Basis methods in Account
	 *            Maintenance -> Cost Basis Methods page
	 */
	public boolean verifyInAccountmaintainance(String accnum, String cbmthd) {
		int rowcount;
		WebElement cbMethod;
		int costBasisMethodsCnt = 0;

		myhomepage.navigateToAcctMaintnce();
		try {
			acctmtpageintrl.navigateToCostBasisMethodPage();
		} catch (PageNavigationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SeleniumWaitHelper.pause(5);
		rowcount = driver
				.findElements(By.xpath("//span[contains(text(),'" + accnum + "')]/ancestor::tr/following-sibling::tr"))
				.size();
		for (int count = 1; count <= rowcount; count++) {
			cbMethod = driver.findElement(By.xpath(
					"//span[contains(text(),'" + accnum + "')]/ancestor::tr/following-sibling::tr[" + count + "]"));
			if (cbMethod.getText().contains(cbmthd)) {
				LoggingUtility.logInfo("for fund" + count + " CB method is changed to" + cbMethod.getText());
				costBasisMethodsCnt = costBasisMethodsCnt + 1;
			}

		}
		if (costBasisMethodsCnt == rowcount - 2) {
			System.out.println("its changed for all funds for VTA with account :" + accnum + "to CB method" + cbmthd);
			return true;
		}
		// if cbmethod is present in all rows except first 1 header
		// row(symbol) for TA
		if (costBasisMethodsCnt == rowcount - 1) {
			System.out
					.println("its changed for all funds for TA with account name:" + accnum + "to CB method" + cbmthd);
			return true;
		}

		return false;

	}

	/**
	 * US051724 Mar 11, 2016
	 * 
	 * @param acctnum
	 * @param cbmethod
	 */
	public boolean revertbackToInitial(String acctnum, String cbmethod) {
		/*
		 * WebElement account = driver.findElement(By
		 * .xpath("//td/span[contains(text(),'" + acctnum + "')]"));
		 * waitformedriver.until(ExpectedConditions.visibilityOf(account));
		 */
		By accntNum = By.xpath("//td/span[contains(text(),'" + acctnum + "')]");

		if (isDisplayed(accntNum, 50)) {
			if (navigateToChangeCostBasisPage(acctnum) && changeAllMutualFundsTo(acctnum, cbmethod)
					&& submitChanges(acctnum, cbmethod))
				return true;
		}
		return false;

	}

	public boolean isCurrentlyLoaded() {
		// TODO Auto-generated method stub
		return (costBasisHdr != null) && (isDisplayed(costBasisHdr, 10));
	}

	/**
	 * US051729 May 11, 2016
	 * 
	 * @param cbmethod
	 * @param accnt
	 * @param fund
	 *            This method is to change Cost Basis method for a single fund
	 */
	public void changeCBMethodForAFund(String cbmethod, String accnt, String fund) {
		navigateToChangeCostBasisPage(accnt);
		By dropdownClick = By.xpath("//td[contains(text(),'" + fund
				+ "')]/following-sibling::td//td/span[@class='vg-SelOneMenuInputCont']");

		if (!isDisplayed(dropdownClick, 30)) {
			throw new ElementNotVisibleException("Could not find dropdown in to change Cost Basis method");
		}
		Actions ac = new Actions(driver);
		ac.keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys(org.openqa.selenium.Keys.END).build().perform();

		click(dropdownClick, 20);

		// Select particular cost basis for particular fund
		By perticularCBMethod = By
				.xpath("//div[contains(@class,'vg-SelOneMenuDropDown vg-SelOneMenuNoWrap vg-SelOneMenuDropDownAtBottom')]//tbody/tr/td[contains(text(),'"
						+ cbmethod + "')]");
		if (!isDisplayed(perticularCBMethod, 30)) {
			throw new ElementNotVisibleException(
					"Could not find" + perticularCBMethod + "in to change Cost Basis method");
		}
		click(perticularCBMethod, 20);

	}

	/**
	 * US056483 Mar 06, 2017
	 * 
	 * @param cbmethod
	 * @param accnt
	 * @param fund
	 *            This method is to verify the selected Cost Basis method for a
	 *            single fund
	 */
	public boolean verifySelectedCBMethodForAFund(String fromCBmethod, String accnt, String fund) {
		// navigateToChangeCostBasisPage(accnt); dont need to navigate again
		// because already page displayed
		if (!isDisplayed(changecostbasisHdr, 30)) {
			throw new ElementNotVisibleException("Could not find 'Change cost basis methods' page");
		}
		By costBasisMethodDropdown = By.xpath("//td[contains(text(),'" + fund
				+ "')]/following-sibling::td//td/span[@class='vg-SelOneMenuInputCont']");
		/*
		 * if (isDisplayed(dropdownClick, 30)) { click(dropdownClick, 20);
		 * SeleniumWaitHelper.pause(5); // Select particular cost basis for
		 * particular fund By perticularCBMethod = By .xpath(
		 * "//div[contains(@class,'vg-SelOneMenuDropDown vg-SelOneMenuNoWrap vg-SelOneMenuDropDownAtBottom')]//tbody/tr/td[contains(text(),'"
		 * + fromCBmethod + "')]"); if (isDisplayed(perticularCBMethod, 30))
		 * 
		 * if(isSelected(perticularCBMethod)) return true; } return false;
		 */
		if (getText(costBasisMethodDropdown).contains(fromCBmethod)) {
			return true;
		}
		return false;

	}

	/**
	 * US051724 Mar 22, 2016
	 */
	public boolean clickContinue() {
		if (isDisplayed(costBasiscontinue, 20)) {
			click(costBasiscontinue, 10);
			return true;

		}
		return false;
	}

	/**
	 * US051724 May 11, 2016 This method is to get Cost Basis Methods change
	 * layer
	 */
	public void costBasisMethodsChangeLayer() {
		By chengeCBPopup = By
				.xpath("//div[contains(text(),'Important information about changing cost basis methods')]");
		if (!isDisplayed(chengeCBPopup, 15)) {

			clickContinue();
		}
		// isDisplayed(chengeCBPopup, 30);
		click(costLayercontinue, 20);

	}

	/**
	 * US051729 May 11, 2016
	 * 
	 * @param cbmethod
	 * @param fund
	 *            This method is to verify Cost Basis Method in Review and
	 *            Submit pages
	 */
	public boolean verifyCBMethodForSingleFundInReviewConfirmPage(String cbmethod, String fund) {

		By cbMethod = By.xpath(
				"//td[contains(text(),'" + fund + "')]/following-sibling::td[contains(text(),'" + cbmethod + "')]");
		if (isDisplayed(cbMethod, 10))
			return true;

		return false;
	}

	/**
	 * US051729 May 11, 2016
	 */
	public boolean clickSubmitBtn() {

		if (isDisplayed(submitButton, 20)) {
			click(submitButton, 10);
			SeleniumWaitHelper.pause(3);
			return true;
		}
		return false;

	}

	/**
	 * US051724 Mar 16, 2016 US056483 - Added cbMethodForNotEstablished variable
	 * and code to deal with Not Established CBMethod for Gifted Shares module
	 * 
	 * @param cbmethod
	 * @param acct
	 * @param fund
	 */
	public boolean verifyCBForSingleFundInCBMethodsPage(String cbmethod, String acct, String fund) {
		SeleniumWaitHelper.pause(12);
	
/*		By cbMethod = By.xpath(
				"//span[contains(text(),'" + acct + "')]/ancestor::tr/following-sibling::tr//td[contains(text(),'"
						+ fund + "')]/following-sibling::td[contains(text(),'" + cbmethod + "')]");
		By cbMethodForNotEstablished = By.xpath(
			"//span[contains(text(),'" + acct + "')]/ancestor::tr/following-sibling::tr//td[contains(text(),'"
						+ fund + "')]/following-sibling::td//span[contains(text(),'" + cbmethod
						+ "') and contains(@id,'CostBasisAccountMaintChangeForm:selectOneDropDown')]");		
						changecostbasisHdr
*/
	
		By fundName = By.xpath("//td[contains(text(),'" + fund + "')]");
		By costbasismethod = By.xpath("//td[contains(text(),'" + cbmethod + "')]");
		By cbMethodForNotEstablished = By.xpath("//span[contains(text(),'" + cbmethod + "')]");

		if (isDisplayed(fundName, 30) && (isDisplayed(costbasismethod, 30)|| isDisplayed(cbMethodForNotEstablished, 30)))
		{
			return true;
		}
		return false;


	}

	/**
	 * US051724 Mar 1, 2016
	 * 
	 * @param cbMethod
	 * @param accnt
	 * @param fund
	 */
	public void revertCBMethodForSingleFund(String cbMethod, String accnt, String fund) {
		changeCBMethodForAFund(cbMethod, accnt, fund);
		clickContinue();
		costBasisMethodsChangeLayer();
		clickSubmitBtn();
		verifyCBMethodForSingleFundInReviewConfirmPage(cbMethod, fund);
	}

	/**
	 * US051724 Mar 15, 2016
	 */
	public boolean verifyChangecbMethodsPage() {

		if (isDisplayed(changecostbasisHdr, 10))
			return true;
		return false;

	}

	/**
	 * us051729 Nov 30, 2016
	 * 
	 * @param account
	 * @param fund
	 */
	public String getDefaultCBMethodFromCostBasisMethodsPage(String account, String fund) {

		Actions ac = new Actions(driver);
		ac.keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys(org.openqa.selenium.Keys.END).build().perform();

		By defaultCBMethod = By.xpath(
				"//td/span[contains(text(),'" + account + "')]/ancestor::tr/following-sibling::tr/td[contains(text(),'"
						+ fund + "')]/following-sibling::td[contains(@class,'nr left')][@align='left']");
		if (getText(defaultCBMethod).contains("*")) {

			String str = getText(defaultCBMethod);
			int index = str.indexOf("(");
			String str1 = str.substring(index, str.length()).replaceAll("[()*]", "");
			return str1;
		} else {
			return getText(defaultCBMethod);
		}
	}

	/**
	 * us056483 June 06, 2017 This method added to cancel the Change Costbasis
	 * method
	 * 
	 */
	public void cancelChangeCostBasisMethodFromChangeCostBasisPage() {

		if (isDisplayed(cancelButton, 20))
			click(cancelButton, 10);
		if (isDisplayed(yesButton, 20))
			click(yesButton, 10);
	}
}
