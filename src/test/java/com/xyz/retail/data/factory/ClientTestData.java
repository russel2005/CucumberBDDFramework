package com.xyz.retail.data.factory;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vanguard.selenium.inner.logon.user.ChannelType;
import com.vanguard.selenium.inner.logon.user.SearchType;
import com.vanguard.selenium.inner.logon.user.TestCrewMemberInformation;
import com.vanguard.service.TestCrewMemberInformationRetrievalService;

@Component
@Scope("cucumber-glue")
public class ClientTestData {

	private ClientDataType clientType;

	private String channel;
	private String userID;
	private String crewUserID;
	private String clientPOID;

	public ChannelType getChannelType() {
		return ChannelType.fromString(channel);
	}

	public TestCrewMemberInformation getInternalUser() {
		TestCrewMemberInformation internalUserInformation = null;
		if (isInternal()) {
			internalUserInformation = TestCrewMemberInformationRetrievalService.lookupUser(crewUserID,
					SearchType.USER_ID);
		}
		return internalUserInformation;
	}

	public boolean isInternal() {
		return isMail() || isPhone();
	}

	public boolean isMail() {
		return StringUtils.equalsIgnoreCase(channel, "mail");
	}

	public boolean isPhone() {
		return StringUtils.equalsIgnoreCase(channel, "phone");
	}

	public ClientDataType getClientType() {
		return clientType;
	}

	public void setClientType(ClientDataType clientType) {
		this.clientType = clientType;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCrewUserID() {
		return crewUserID;
	}

	public void setCrewUserID(String crewUserID) {
		this.crewUserID = crewUserID;
	}

	public String getClientPOID() {
		return clientPOID;
	}

	public void setClientPOID(String clientPOID) {
		this.clientPOID = clientPOID;
	}

}
