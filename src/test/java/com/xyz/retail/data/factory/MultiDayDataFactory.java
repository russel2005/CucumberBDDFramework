package com.xyz.retail.data.factory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.vanguard.retail.data.support.DataExtractForMultiday;

public class MultiDayDataFactory {

	public static MultiDayData getCostBasisTransactionInformtion(String primaryKey, String sheetName)
			throws IOException {
		DataExtractForMultiday testCrewDataExtract = new DataExtractForMultiday();
		MultiDayData excelRowData = null;
		excelRowData = new MultiDayData(
				testCrewDataExtract.getExcelDataInformationByPrimaryKey(primaryKey, sheetName));
		return excelRowData;
	}

	public static void setCostBasisCPTInformtion(String primaryKey, String sheetName,
			Map<String, String> rowDetails) throws IOException {
		DataExtractForMultiday testCrewDataExtract = new DataExtractForMultiday();
		Set set = rowDetails.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry rowEntry = (Map.Entry) iterator.next();
			testCrewDataExtract.setExcelDataInformationByPrimaryKey(primaryKey, sheetName, rowEntry.getKey().toString(),
					rowEntry.getValue().toString());

		}
	}
}
