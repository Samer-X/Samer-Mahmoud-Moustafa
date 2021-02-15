package commonUtils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelHelper {

    static XSSFWorkbook workBook;
    static XSSFSheet sheet;

    public ExcelHelper(String excelPath, String sheetName) {
        try {
            workBook = new XSSFWorkbook(excelPath);
            sheet = workBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }
    }

    public String getFirstName(int rowNumber) {
        String firstName = sheet.getRow(rowNumber).getCell(2).getStringCellValue();
        return firstName;
    }

    public String getLastName(int rowNumber) {
        String lastName = sheet.getRow(rowNumber).getCell(3).getStringCellValue();
        return lastName;
    }

    public String getEmail(int rowNumber) {
        String email = sheet.getRow(rowNumber).getCell(0).getStringCellValue();
        return email;
    }

    public String getPassword(int rowNumber) {
        String password = sheet.getRow(rowNumber).getCell(1).getStringCellValue();
        return password;
    }

}
