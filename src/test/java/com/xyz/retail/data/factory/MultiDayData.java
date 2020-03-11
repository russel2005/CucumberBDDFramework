package com.xyz.retail.data.factory;

import java.util.Map;

public class MultiDayData {

	private String currentSharesInToFund;
	private String fundSymbol;
	private String brokerageAccountNumber;
	private String vastAccountNumber;
	private String sharesTransferredIntoToFund;
	private String confirmationNumber;
	private String zNumber;
	private String taToVBADTCCFirmNumber;
	private String vbaToTADTCCFirmNumber;
	private String contraFirmNumberForTA;
	private String contraFirmNumberForVBA;
	private String cbrsTransferType;

	public MultiDayData() {
		super();
	}

	public MultiDayData(Map<String, String> excelRowData) {
		this.currentSharesInToFund = excelRowData.get("currentSharesInToFund");
		this.fundSymbol = excelRowData.get("fundSymbol");
		this.brokerageAccountNumber = excelRowData.get("brokerageAccountNumber");
		this.vastAccountNumber = excelRowData.get("vastAccountNumber");
		this.sharesTransferredIntoToFund = excelRowData.get("sharesTransferredIntoToFund");
		this.confirmationNumber = excelRowData.get("confirmationNumber");
		this.zNumber = excelRowData.get("zNumber");
	}

	public String getCurrentSharesInToFund() {
		return currentSharesInToFund;
	}

	public String getBrokerageAccountNumber() {
		return brokerageAccountNumber;
	}

	public String getVastAccountNumber() {
		return vastAccountNumber;
	}

	public String getSharesTransferredIntoToFund() {
		return sharesTransferredIntoToFund;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public String getZNumber() {
		return zNumber;
	}

	public String getFundSymbol() {
		return fundSymbol;
	}

	public String getTAToVBADTCCFirmNumber() {
		return taToVBADTCCFirmNumber == null ? "D5772" : taToVBADTCCFirmNumber;
	}

	public String getVBAToTADTCCFirmNumber() {
		return vbaToTADTCCFirmNumber == null ? "D0062" : vbaToTADTCCFirmNumber;
	}

	public String getContraFirmNumberForTA() {
		return contraFirmNumberForTA == null ? "0062" : contraFirmNumberForTA;
	}

	public String getContraFirmNumberForVBA() {
		return contraFirmNumberForVBA == null ? "5772" : contraFirmNumberForVBA;
	}

	public String getCbrsTransferType() {
		return cbrsTransferType == null ? "57" : cbrsTransferType;
	}

}
