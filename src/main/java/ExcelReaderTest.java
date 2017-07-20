


public class ExcelReaderTest {

	public static void main(String[] args) {
		ExcelReader excelReader = new ExcelReaderImpl();
		String excelUrl = "D:/ExcelReadTest.xlsx";

		String[][] excelArray = excelReader.readExcel(excelUrl);

		for (String[] strings : excelArray) {
			for (String string : strings) {
				System.out.println(string);
			}
		}
	}
}
