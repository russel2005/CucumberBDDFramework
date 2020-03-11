package com.xyz.retail.cucumber.stepdefs;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.vanguard.retail.cucumber.helpers.CostBasisCPTDataHelper;
import com.vanguard.retail.cucumber.support.CostBasisUserInterface;
import com.vanguard.retail.data.factory.ClientDataType;
import cucumber.api.java.en.Given;

public class ClientStepDefs {

	@Autowired
	CostBasisUserInterface costBasisUserInterface;
	@Autowired
	CostBasisCPTDataHelper costBasisCPTDataHelper;

	@Given("^I login as \"([^\"]*)\"$")
	public void iloginas(String user) throws Throwable {
		costBasisUserInterface.externalLogin(user);
	}

	@Given("^I search for client with \"(.*?)\"$")
	public void isearchedfor(String poid) throws Throwable {
		costBasisUserInterface.internalLogin(poid);
	}

	@Given("^Process associate searches for a TA client who can access VBA account of secondary client$")
	public void processAssociateSearchesForATAClientWhoCanAccessVBAAccountOfSecondaryClient(
			List<CostBasisCPTDataHelper> costBasisCPTDetails) throws Throwable {
		costBasisCPTDataHelper.setCostBasisCPTData(costBasisCPTDetails.get(0));
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_TAToVBA_PrimaryClient.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a TA client who had done a CPT to VBA$")
	public void processAssociateSearchesForATAClientWhoHadDoneACPTToVBA() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_TAToVBA_PrimaryClient.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a TA client$")
	public void processAssociateSearchesForATAClient(List<CostBasisCPTDataHelper> costBasisCPTDetails)
			throws Throwable {
		costBasisCPTDataHelper.setCostBasisCPTData(costBasisCPTDetails.get(0));
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.ChangeOfOwnership_Primary.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
		costBasisUserInterface.navigateToCostBasisPage();
		costBasisUserInterface.saveCurrentQuantityOfSharesForToFundIntoExcel();
		costBasisUserInterface.navigateToAWD(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^VBA client who also has a TA account logs in$")
	public void vbaClientWhoAlsoHasATAAccountLogsIn(List<CostBasisCPTDataHelper> costBasisCPTDetails) throws Throwable {
		costBasisCPTDataHelper.setCostBasisCPTData(costBasisCPTDetails.get(0));
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_VBAToTA.toString());
		costBasisUserInterface.externalLogin(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a VBA client who had done a CPT to TA$")
	public void processAssociateSearchesForAVBAClientWhoHadDoneACPTToTA() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_VBAToTA.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a TA client who had done a COO to VBA$")
	public void processAssociateSearchesForATAClientWhoHadDoneACOOToVBA() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.ChangeOfOwnership_Primary.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a VBA client on which a CPT transaction had processed$")
	public void processAssociateSearchesForAVBAClientOnWhichACPTTransactionHadProcessed() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_TAToVBA_SecondaryClient.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_TAToVBA_PrimaryClient.toString());
	}

	@Given("^Process associate searches for a TA client on which a CPT transaction had processed$")
	public void processAssociateSearchesForATAClientOnWhichACPTTransactionHadProcessed() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.CPT_VBAToTA.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
	}

	@Given("^Process associate searches for a VBA client on which a COO transaction had processed$")
	public void processAssociateSearchesForAVBAClientOnWhichACOOTransactionHadProcessed() throws Throwable {
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.ChangeOfOwnership_Secondary.toString());
		costBasisUserInterface.loginToCrave(costBasisCPTDataHelper.getPrimaryKey());
		costBasisCPTDataHelper.setPrimaryKey(ClientDataType.ChangeOfOwnership_Primary.toString());
	}

}
