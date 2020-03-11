package com.xyz.retail.data.support;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.vanguard.selenium.inner.core.utils.LoggingUtility;
import com.vanguard.util.CsvReader;

public class CrewUserDataExtract {
	private static Map<String, CrewUserInfo> usersMap;

	public String getUserIdInformationByCrewType(String crewUserType) {
		String userId = null;
		if (usersMap == null) {
			createMap();
		}
		for (CrewUserInfo user : usersMap.values()) {
			if (userNotNull(user)) {
				String crewType = user.getCrewType();
				if (crewType != null && crewType.equalsIgnoreCase(crewUserType)) {
					userId = user.getUserId();
				}
			}
		}
		return userId;
	}

	private static boolean userNotNull(CrewUserInfo user) {
		return (user != null);
	}

	public Map<String, CrewUserInfo> createMap() {
		Map<String, CrewUserInfo> newUsersMap = new HashMap<String, CrewUserInfo>();

		try {
			Collection<Object[]> data = CsvReader
					.getData("src/test/resources/IntCrewUsers.csv");
			Iterator<Object[]> iterator = data.iterator();
			iterator.next();
			while (iterator.hasNext()) {
				Object[] userData = iterator.next();

				final String crewType = (String) userData[4];
				final String key = crewType;
				CrewUserInfo userInformation = new CrewUserInfo();
				userInformation.setUserId((String) userData[2]);
				userInformation.setCrewType((String) userData[4]);
				newUsersMap.put(key, userInformation);
			}

		} catch (Throwable e) {
			LoggingUtility.logError(
					"Error retrieving user information data from CSV file.", e);
		}

		return usersMap = newUsersMap;
	}

}
