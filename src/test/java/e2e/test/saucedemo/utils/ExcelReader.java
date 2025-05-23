package e2e.test.saucedemo.utils;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static List<Map<String, String>> readExcel(String filePath, String sheetName) {
		List<Map<String, String>> data = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(fis)) {
			Sheet sheet = workbook.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Map<String, String> rowData = new HashMap<>();

				for (int j = 0; j < headerRow.getLastCellNum(); j++) {
					String key = headerRow.getCell(j).getStringCellValue();
					String value = getCellValue(row.getCell(j));
					rowData.put(key, value);
				}
				data.add(rowData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	private static String getCellValue(Cell cell) {
		if (cell == null)
			return "";

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue().trim();
		case Cell.CELL_TYPE_NUMERIC:
			return String.valueOf((long) cell.getNumericCellValue());
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}
}
