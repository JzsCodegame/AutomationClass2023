package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class ExcellDataProvider {
	@DataProvider(name = "testdata")
    public static Object[][] getTestData() throws IOException {
        String filepath = "path/to/testdata.xlsx";
        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rows-1][cols];
        for(int i=1;i<rows;i++) {
            Row row = sheet.getRow(i);
            for(int j=0;j<cols;j++) {
                Cell cell = row.getCell(j);
                switch(cell.getCellType()) {
                    case STRING:
                        data[i-1][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i-1][j] = cell.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        data[i-1][j] = cell.getBooleanCellValue();
                        break;
                    default:
                        data[i-1][j] = "";
                        break;
                }
            }
        }
        workbook.close();
        return data;
    }
}
