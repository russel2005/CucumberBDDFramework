package com.xyz.retail.cucumber.helpers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class CostBasisCPTDataHelper {

	private String fromAccount;
	private String fromFund;
	private String toAccount;
	private String toFund;
	private String primaryKey;
	private String shares;
	private String businessArea;
	private String workType;
	private String status;
	private String typeOfChange;

	public void setCostBasisCPTData(CostBasisCPTDataHelper balanceAndHoldingDataHelper) {
		this.fromAccount = balanceAndHoldingDataHelper.getFromAccount();
		this.fromFund = balanceAndHoldingDataHelper.getFromFund();
		this.toAccount = balanceAndHoldingDataHelper.getToAccount();
		this.toFund = balanceAndHoldingDataHelper.getToFund();
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getFromFund() {
		return fromFund;
	}

	public void setFromFund(String fromFund) {
		this.fromFund = fromFund;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getToFund() {
		return toFund;
	}

	public void setToFund(String toFund) {
		this.toFund = toFund;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getShares() {
		return shares;
	}

	public void setShares(String shares) {
		this.shares = shares;
	}

	public String getBusinessArea() {
		return businessArea == null ? "OPS COO" : businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getWorkType() {
		return workType == null ? "VBA COO" : workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getStatus() {
		return status == null ? "INDEXED" : status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeOfChange() {
		return typeOfChange == null ? "Gift by Spec ID" : typeOfChange;
	}

	public void setTypeOfChange(String typeOfChange) {
		this.typeOfChange = typeOfChange;
	}

}
