package readexcel;

import com.test.gtl.util.ExcelReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class Homework26_2 {

        private String excelPath;
        private XSSFWorkbook workbook;
        private static XSSFSheet sheet;
        static int mk = 0;
        static int tableDataStartsAtRow = 0;
        static int tableDataEndsAtRow = 0;
        static int tableColumnsSize = 0;


        public void ExcelReader (String excelPath, String sheetName) {
            this.excelPath = excelPath;
            try {
                FileInputStream fis;
                fis = new FileInputStream(excelPath);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheet(sheetName);
                fis.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        // Methods/logic
        public int getTableData(String tableNameProvided) {

            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.toString().equalsIgnoreCase(tableNameProvided)) {
                        tableDataStartsAtRow = row.getRowNum();
                        endRow();

                        break;
                    }
                }
            }
            return tableDataStartsAtRow;


        }

        public int endRow() {
            Iterator<Row> rows = sheet.iterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                if (row.getRowNum() - mk > 1 && row.getRowNum() > tableDataStartsAtRow) {
                    tableDataEndsAtRow = mk;
                    tableColumnsSize = sheet.getRow(mk).getLastCellNum();
                    return tableDataEndsAtRow;
                } else if (row.getRowNum() == sheet.getLastRowNum()) {
                    tableDataEndsAtRow = row.getRowNum();
                    tableColumnsSize = row.getLastCellNum();
                    return tableDataEndsAtRow;
                }
                mk = row.getRowNum();
            }
            return tableDataEndsAtRow;
        }



        public Object[][] createTabledata() {
            Object[][] tableData = new Object[tableDataEndsAtRow - tableDataStartsAtRow][tableColumnsSize];
            int k = 0;
            // Get the table data
            // Loop each row
            for (int i = tableDataStartsAtRow + 1; i <= tableDataEndsAtRow; i++) {


                XSSFRow row = sheet.getRow(i);

                // Loop each column
                for (int j = 0; j < tableColumnsSize; j++) {
                    tableData[k][j] = row.getCell(j);
                }
                k++;
            }

            return tableData;
        }

        public static void main(String[] args) {


          ExcelReader excelReader = new ExcelReader("C:\\Users\\sayar\\IdeaProjects\\my-testing\\src\\main\\java\\resources\\TestData.xlsx", "Sheet1");
            excelReader.getTableData("users");
            System.out.println(tableDataStartsAtRow + " " + tableDataEndsAtRow + " " + tableColumnsSize + " ");

            Object[][] data = excelReader.createTabledata();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[0].length; j++) {
                    System.out.print(data[i][j] + "\t");
                }
                System.out.println();
            }

        }
    }

