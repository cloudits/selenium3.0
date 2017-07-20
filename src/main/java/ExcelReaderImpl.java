import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Created by liurui on 2017-07-20.
 */

public class ExcelReaderImpl implements ExcelReader {

	@Override
	public String[][] readExcel(String url) {

		Workbook workbook = getExcelInputStream(url);

		if (workbook == null || workbook.getNumberOfSheets() < 1) {
			System.out.println("读取excel错误或sheet为空");
			return null;
		}
		if (workbook.getNumberOfSheets() < 1) {
			System.out.println("sheet为空");
			return null;
		}

		return readToArray(workbook);
	}

	private String[][] readToArray(Workbook workbook) {
		Sheet sheet = workbook.getSheetAt(0); //读取第一个Sheet
		int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数
		if (rowCount < 1) {
			System.out.println("行数为空");
			return null;
		}

		//创建最外层数组
		String[][] rowArray = new String[rowCount][];
		//遍历每一行  
		for (int r = 0; r < rowCount; r++) {
			Row row = sheet.getRow(r);
			int cellCount = row.getPhysicalNumberOfCells(); //获取总列数
			if (cellCount < 1) {
				continue;
			}
			//创建每一行存储数组
			String[] cellArray = new String[cellCount];
			//遍历每一列  
			for (int c = 0; c < cellCount; c++) {
				Cell cell = row.getCell(c);
				cellArray[c] = getCellStringValue(cell);
			}
			rowArray[r] = cellArray;
		}
		return rowArray;
	}

	private static final SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

	private String getCellStringValue(Cell cell) {
		String cellValue = null;
		int cellType = cell.getCellType();
		switch (cellType) {
		case Cell.CELL_TYPE_STRING: //文本  
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC: //数字、日期  
			if (DateUtil.isCellDateFormatted(cell)) {
				cellValue = fmt.format(cell.getDateCellValue()); //日期型  
			} else {
				cellValue = String.valueOf(cell.getNumericCellValue()); //数字  
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN: //布尔型  
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_BLANK: //空白  
			cellValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_ERROR: //错误  
			cellValue = "错误";
			break;
		case Cell.CELL_TYPE_FORMULA: //公式  
			cellValue = "暂不支持公式";
			break;
		default:
			cellValue = "读取错误";
		}
		return cellValue;
	}

	private Workbook getExcelInputStream(String url) {
		File excelFile = new File(url); //创建文件对象  
		FileInputStream is;
		Workbook workbook = null;
		try {
			is = new FileInputStream(excelFile);
			workbook = WorkbookFactory.create(is); //支持 Excel 2003/2007/2010 
		} catch (Exception e) {
			System.out.println("读取excel错误"+e);
		}
		return workbook;
	}

}
