package com.fsd.stock.attachment.util;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	private static DecimalFormat df = new DecimalFormat("#.##");
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * This method is used to according the excel InputStream fetch the data
	 * 
	 * @param inputStream
	 * @param excelVersion
	 * @param sheetIndex
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private static List<Map> readExcel(InputStream inputStream, int sheetIndex) throws Exception {
		Workbook wb = null;
		wb = WorkbookFactory.create(inputStream);
		Sheet sheet = null;

		sheet = wb.getSheetAt(sheetIndex);
		int colNum = sheet.getRow(0).getLastCellNum();
		if (colNum > 100) {
			colNum = 100;
		}
		int rowNum = sheet.getLastRowNum();

		List<Map> contentList = new ArrayList<Map>();

		for (int i = 1; i <= rowNum; i++) {
			Map<String, String> cellMap = new TreeMap<String, String>();
			Row row = sheet.getRow(i);
			if (row != null) {
				for (int j = 0; j < colNum; j++) {
					if (j > 100) {
						break;
					}
					Cell cell = row.getCell(j);
					try {
						String titleValue = getCellValue(sheet.getRow(0).getCell(j)).trim();
						String fieldValue = getCellValue(cell).trim();
						cellMap.put(titleValue, fieldValue);
					} catch (IllegalStateException e) {

					}
				}
			}
			if (!cellMap.isEmpty()) {
				contentList.add(cellMap);
			}
		}
		return contentList;
	}

	/**
	 * 
	 * @param <T>
	 * @param dataList
	 * @param fileds
	 * @param titles
	 * @param clz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T> List<T> converToList(List<Map> dataList, String[] fileds, String[] titles, Class<T> clz)
			throws Exception {
		List<T> list = new ArrayList<T>();
		Map<String, String> cellMap = null;
		Iterator<Entry<String, String>> iterators = null;
		Entry<String, String> entry = null;
		T targetObj = null;
		String columTitle = "";
		String cellValue = "";
		Method method;
		int cursor = -1;
		for (int i = 0, size = dataList.size(); i < size; i++) {
			cellMap = (Map<String, String>) dataList.get(i);
			iterators = cellMap.entrySet().iterator();
			targetObj = clz.newInstance();
			while (iterators.hasNext()) {
				entry = iterators.next();
				columTitle = (String) entry.getKey();
				cellValue = (String) entry.getValue();
				cursor = CommonUtility.getIndexInArray(titles, columTitle);
				if (-1 != cursor) {
					method = clz.getMethod("set" + CommonUtility.firstLetterUpper(fileds[cursor]), String.class);
					method.invoke(targetObj, cellValue);
				}
			}
			list.add(targetObj);
		}
		return list;
	}

	/**
	 * 
	 * @param <T>
	 * @param inputStream
	 * @param sheetIndex
	 * @param fileds
	 * @param titles
	 * @param clz
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static <T> List<T> readExcelSheet(InputStream inputStream, int sheetIndex, String[] fileds, String[] titles,
			Class<T> clz) throws Exception {
		List<Map> dataList = readExcel(inputStream, sheetIndex);
		if (dataList == null) {
			return null;
		}
		List<T> list = converToList(dataList, fileds, titles, clz);

		return list;
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	private static String getCellValue(Cell cell) {
		String cellValue = "";

		switch (cell.getCellType()) {
		case STRING:
			cellValue = cell.getRichStringCellValue().getString().trim();
			break;
		case NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				return dateFormat.format(cell.getDateCellValue());
			} else {
				cellValue = df.format(cell.getNumericCellValue()).toString();
			}
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue()).trim();
			break;
		case FORMULA:
			cellValue = cell.getCellFormula();
			break;
		default:
			cellValue = "";
		}
		return cellValue;
	}

}
