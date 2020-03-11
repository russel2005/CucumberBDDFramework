package com.xyz.retail.data.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

public class DataExtractForMultiday {
	String excelName = new File("").getAbsolutePath()
			+ "//src//test//resources//CostBasisMultiDayData.xls";

	File readOnlyFile = new File(excelName);
	boolean isWritable = readOnlyFile.setWritable(true);

	public Map<String, String> getExcelDataInformationByPrimaryKey(String primaryKey, String sheetName)
			throws IOException {

		HSSFRow row = null;
		FileInputStream file = new FileInputStream(excelName);

		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheet(sheetName);

		row = getRowUsingPrimaryKey(primaryKey, sheet);
		HashMap<String, String> record = new HashMap<String, String>();
		for (int i = 0; i <= row.getLastCellNum(); i++) {

			record.put(getContentAsText(sheet.getRow(0).getCell(i)), getContentAsText(row.getCell(i)));
		}

		return record;

	}

	public HSSFRow getRowUsingPrimaryKey(String primaryKey, HSSFSheet sheet) {

		HSSFRow row = null;
		HSSFCell cell = null;

		HSSFRow iRow = null;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			row = sheet.getRow(i);
			cell = row.getCell(0);
			if (getContentAsText(cell).equals(primaryKey)) {
				iRow = sheet.getRow(i);
			}

		}
		return iRow;
	}

	public String getContentAsText(HSSFCell cell) {
		String text = null;
		Calendar cal = null;
		try {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC: {
				double d = cell.getNumericCellValue();
				if (isCellDateFormatted(cell)) {
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					String cellText = "";
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
				} else {
					String a = String.valueOf(d);
					if (a.contains(".0")) {
						String[] b = a.split(".0");
						a = b[0];
					}
					text = a;
				}
				break;
			}
			case HSSFCell.CELL_TYPE_FORMULA:
				text = cell.getCellFormula().toString();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				text = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				text = String.valueOf(cell.getErrorCellValue());
				break;
			case HSSFCell.CELL_TYPE_STRING:
				text = cell.getStringCellValue().toString();
				break;
			default:
				break;
			}

		} catch (Exception e) {
		}
		return text;
	}

	public static boolean isCellDateFormatted(HSSFCell cell) {
		boolean bDate = false;
		double d = cell.getNumericCellValue();
		if (HSSFDateUtil.isValidExcelDate(d)) {
			HSSFCellStyle style = cell.getCellStyle();
			int i = style.getDataFormat();
			switch (i) {
			case 0xe:
			case 0xf:
			case 0x10:
			case 0x11:
			case 0x12:
			case 0x13:
			case 0x14:
			case 0x15:
			case 0x16:
			case 0x2d:
			case 0x2e:
			case 0x2f:
				bDate = true;
				break;
			default:
				bDate = false;
				break;
			}
		}
		return bDate;
	}

	public void setExcelDataInformationByPrimaryKey(String primaryKey, String sheetName, String columnName,
			String value) {

		boolean isPrimaryKeyExists = false;
		HSSFRow row = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;

		try {

			FileInputStream file = new FileInputStream(excelName);
			workbook = new HSSFWorkbook(file);
			sheet = workbook.getSheet(sheetName);
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setLocked(false);
			int numberOfColumns = sheet.getRow(0).getLastCellNum();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);

				if (getContentAsText(row.getCell(0)) != null
						&& (getContentAsText(row.getCell(0)).equalsIgnoreCase(primaryKey))) {

					for (int j = 0; j <= numberOfColumns; j++) {

						if (getContentAsText(sheet.getRow(0).getCell(j)).equalsIgnoreCase(columnName)) {

							sheet.getRow(i).getCell(j).setCellType(sheet.getRow(i).getCell(j).CELL_TYPE_STRING);
							sheet.getRow(i).getCell(j).setCellValue(value);
							isPrimaryKeyExists = true;

							break;
						}
					}
				} else if (getContentAsText(row.getCell(0)) == null) {
					sheet.removeRow(row);

				}

			}

			if (!isPrimaryKeyExists) {

				int i = sheet.getLastRowNum() + 1;
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(primaryKey);
				for (int j = 1; j <= numberOfColumns; j++) {
					row.createCell(j);
				}

				for (int j = 0; j <= numberOfColumns; j++) {

					if (getContentAsText(sheet.getRow(0).getCell(j)).equalsIgnoreCase(columnName)) {

						sheet.getRow(i).getCell(j).setCellType(sheet.getRow(i).getCell(j).CELL_TYPE_STRING);
						row.createCell(j).setCellValue(value);

						break;
					}
				}

			}

			FileOutputStream outputStream = new FileOutputStream(excelName);
			workbook.write(outputStream);
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				row = null;
				sheet = null;
				workbook = null;
				System.gc();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
