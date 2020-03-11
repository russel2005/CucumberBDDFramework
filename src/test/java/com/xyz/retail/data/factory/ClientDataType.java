package com.xyz.retail.data.factory;

import java.util.HashMap;
import java.util.Map;

public enum ClientDataType {

	
	TA_POID("TA_POID","IMERLIN","2005217633","Dbcgadeih Pnnnn Omnrlopts Sr. - 1","",""),
	NonVGMutulFund_VTA_User("NonVGMutulFund_VTA_User","BANKBP2731","2005196845","75641796","003021490",""),
	//VTA_Account_ETF_User("VTA_Account_ETF_User","OE34017","996102202","56566512","VCR",""),
	VTA_Account_ETF_User("VTA_Account_ETF_User","OE34017","996102202","34708879","VV",""),
	//vtaBondUser("vtaBondUser","OE34017","996102202","56566512","MVALX",""),
	vtaBondUser("vtaBondUser","OE34017","996102202","34708879","AAZCX",""),
	//vtaBondUser_tradeBondName_BuyLink("vtaBondUser_tradeBondName_BuyLink","OE34017","996102202","56566512","3704A0RT1",""),
	vtaBondUser_tradeBondName_BuyLink("vtaBondUser_tradeBondName_BuyLink","BANKBP2731","2005196845","75641796","26817RAN8",""),
	//vtaBondUser_tradeBondName_SellLink("vtaBondUser_tradeBondName_SellLink","OE34017","996102202","56566512","3704A0RT1",""),
	vtaBondUser_tradeBondName_SellLink("vtaBondUser_tradeBondName_SellLink","BANKBP2731","2005196845","75641796","26817RAN8",""),

	//legacy_vbs_POID_SellLink("legacy_vbs_POID_SellLink","STW1107","2000237399","72467102","C",""),
	legacy_vbs_POID_SellLink("legacy_vbs_POID_SellLink","STW1107","2000237399","72467102","F",""),
	//legacy_vbs_POID_BuyLink("legacy_vbs_POID_BuyLink","STW1107","2000237399","72467102","C",""),
	legacy_vbs_POID_BuyLink("legacy_vbs_POID_BuyLink","STW1107","2000237399","72467102","F",""),
	Legacy_BrokerageAccount_Selllink("Legacy_BrokerageAccount_Selllink","OE34017","996102202","56566512","VCR",""),
	Legacy_BrokerageTrustAccount_Selllink("Legacy_BrokerageTrustAccount_Selllink","OE34017","996102202","56566512","AAPL",""),
	NonVGFunds_VTAAccount_Selllink("NonVGFunds_VTAAccount_Selllink","BANKBP2731","2005196845","75641796","003021490",""),
	//TAAccount_BuyFundspageVerificaton("TAAccount_BuyFundspageVerificaton","TESTWEBA","2005555362","Patrick Davisâ€”Profit Sharing Plan (Self-Managed)","VFIIX",""),
	TAAccount_BuyFundspageVerificaton("TAAccount_BuyFundspageVerificaton","ABCDKK3","2005219135","Ghjjihiac Pnnnn Rsuutstln (Self-Managed)","VHCOX",""),
	TAAccount_ExchangeVGFundsPageVerification("TAAccount_ExchangeVGFundsPageVerification","WADMTAC07","2000225434","Pelling Mondi","VWELX",""),
	TAAccount_SellVGFundsPageVerification("TAAccount_SellVGFundsPageVerification","WADMTAC07","2000225434","Pelling Mondi","VWELX",""),
	VTAAccount_BuyVGMutualFundsPageVerification("VTAAccount_BuyVGMutualFundsPageVerification","BANKBP2731","2005196845","75641796","VFIIX",""),
	VTAAccount_SelllinkVerification("VTAAccount_SelllinkVerification","BANKBP2731","2005196845","75641796","VFIIX",""),
	VTAAccount_VGMFund_ExchangeVGFundsVerification("VTAAccount_VGMFund_ExchangeVGFundsVerification","BANKBP2731","2005196845","75641796","VFIIX",""),
	TA_User("TA_User","CBITEST029","2005198688","Aderes Cbi Montag - 1","VGSTX",""),
	VBS_User("VBS_User","VBSFL45784","1018629280","32244636","AFRAX",""),	
	VIA_User("VIA_User","COST5964","1865547524","65921698","VBINX",""),
	//VIAJoint_Accnt("VIAJoint_Accnt","MARLONSON","2005199266","53333477","VGELX",""),
	VIAJoint_Accnt("VIAJoint_Accnt","CEKM6111","1421632752","28496487","VDAIX",""),
	VTA_Joint_ChangeCBAllFunds("VTA_Joint_ChangeCBAllFunds","POOJAF7113","1230492814","75790826","",""),
	//VTA_Joint_ChangeCBAllFunds("VTA_Joint_ChangeCBAllFunds","POOJA8887","1755890814","17028395","",""),
	TA_Account_ChangeCBAllFunds("TA_Account_ChangeCBAllFunds","PERSH0055","1916668529","Dcaicacab Pnnnn Onltnlnlm","",""),
	//TradeETF_UpdateCostBasisUser("TradeETF_UpdateCostBasisUser","OE33085","2000255405","29509309","","1"),
	TradeETF_UpdateCostBasisUser("TradeETF_UpdateCostBasisUser","EDRT2027","2005217037","20161076","","1"),
	VBS_Account_SellETF_UpdateCostBasis("VBS_Account_SellETF_UpdateCostBasis","MERGE3448","1379008349","79531034","","1"),
	VBS_SellETF_UpdateCostBasis("VBS_SellETF_UpdateCostBasis","BUYSEL9418","2005216398","36274432","",""),
	VBSAccount_UpdateCB_BuyToCover_ETF_PartiallyExec("VBSAccount_UpdateCB_BuyToCover_ETF_PartiallyExec","BUYSEL9418","2005216398","36274432","",""),
	VIAAccount_SellETF_UpdateCostBasis("VIAAccount_SellETF_UpdateCostBasis","MICTEAMADEMO","400034011","28575007","",""),
	VIAAccount_SellETF_UpdateCostBasisTo_FIFO("VIAAccount_SellETF_UpdateCostBasisTo_FIFO","KAREN6547","1354970836","51328252","",""),
	VIA_POID("VIA_POID","CONFI24374","2000342861","53550561","",""),
	VBS_POID("VBS_POID","DARLENE1985","2005205549","58006347","",""),
	VIAAccount_SellETF_UpdateCB_From_SpecID_To_FIFO("VIAAccount_SellETF_UpdateCB_From_SpecID_To_FIFO","KAREN6547","1354970836","40858403","",""),
	 VTA_Account_GiftedShares("VTA_Account_GiftedShares","USAPDIV8472","1181369304","89863433","",""),
	 //VTA_Account_GiftedShares_NotSelectedCostBasisMethod("VTA_Account_GiftedShares_NotSelectedCostBasisMethod","REGRSSN1461","276916516","Daniel Powell","VTEAX",""),
	 VTA_Account_GiftedShares_NotSelectedCostBasisMethod("VTA_Account_GiftedShares_NotSelectedCostBasisMethod","REGRSSN1461","276916516","Daniel Powellâ€”Brokerage Accountâ€”52093009","VFIIX",""),
	 //VTA_Account_GiftedShares_NotSelectedCostBasisMethod("VTA_Account_GiftedShares_NotSelectedCostBasisMethod","USAPDIV8472","1181369304","Lester Wood, Nicole Martinezâ€”Brokerage Accountâ€”89863433","",""),
	 CPT_TAToVBA_PrimaryClient("CPT_TAToVBA_PrimaryClient","KTFDATA2344","724945180","","",""),
	 CPT_TAToVBA_SecondaryClient("CPT_TAToVBA_SecondaryClient","KLORENZ","1943624189","","",""),
	 ChangeOfOwnership_Primary("ChangeOfOwnership_Primary","KTFDATA2361","472952680","","",""),
	 ChangeOfOwnership_Secondary("ChangeOfOwnership_Secondary","ADO3177","1905755431","","",""),
	 CPT_VBAToTA("CPT_VBAToTA","KTFDATA2341","326886970","","","")
	;
	

	private String clientType;
	private String userName;
	private String userPoid;
	private String accountNumber;
	private String fundName;
	private String numofShares;
	
	
	/**
	 * @param clientType
	 * @param userName
	 * @param userPoid
	 * @param accountNumber
	 * * @param fundName
	
	 */
	private ClientDataType(String clientType, String userName, String userPoid,
			String accountNumber,String fundName,String numofShares) {
		this.clientType = clientType;
		this.userName = userName;
		this.userPoid = userPoid;
		this.accountNumber = accountNumber;
		this.fundName = fundName;
		this.numofShares=numofShares;
		
	}

	
	/**
	 * @return the clientType
	 */
	public String getClientType() {
		return clientType;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return the userPoid
	 */
	public String getUserPoid() {
		return userPoid;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * @return the fundName
	 */
	public String getFundName(){
		return fundName;
	}
	
	/**
	 * @return the numofShares
	 */
	public String getNumofShares(){
		return numofShares;
	}

	

	/**
	 * @return the clientinfovalidationtypemap
	 */
	public static Map<String, ClientDataType> getClientinfovalidationtypemap() {
		return clientInfoValidationTypeMap;
	}


	private static Map<String, ClientDataType> clientInfoValidationTypeMap = new HashMap<String, ClientDataType>();

	static {
		for (ClientDataType type : values()) {
			clientInfoValidationTypeMap.put(type.getClientType(), type);
		}
	}

	public static ClientDataType getClientInformationValidationType(
			String clientInfoValidationType) {
		return clientInfoValidationTypeMap.get(clientInfoValidationType);
	}

	
}
