package TestData;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcellDataProvider;

public class SignUpData {
	
	
	@DataProvider (name ="testdata")
    public Object[][] getSignUpData() {

        String excelPath = "path/to/excel/file.xlsx";
        String sheetName = "SignUpData";

        ExcellDataProvider excel = new ExcellDataProvider(excelPath, sheetName);

        Object[][] data = excel.getData();

        return data;
    }
}
