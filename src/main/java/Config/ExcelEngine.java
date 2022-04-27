package Config;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelEngine {

public static String filePathPartRisk;



    /*
            public static void main (String[] args) throws IOException {
    //Path of the excel file

                FileInputStream fs = new FileInputStream("C:\\Users\\ahmed.mahdy\\Desktop\\ee.xlsx");
    //Creating a workbook
                XSSFWorkbook workbook = new XSSFWorkbook(fs);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Row row = sheet.getRow(0);
                Cell cell = row.getCell(0);
                System.out.println(sheet.getRow(0).getCell(0));
               /*
                Row row1 = sheet.getRow(1);
                Cell cell1 = row1.getCell(1);
                System.out.println(sheet.getRow(0).getCell(1));
                Row row2 = sheet.getRow(1);
                Cell cell2 = row2.getCell(1);
                System.out.println(sheet.getRow(1).getCell(0));
                Row row3 = sheet.getRow(1);
                Cell cell3 = row3.getCell(1);
                System.out.println(sheet.getRow(1).getCell(1));

            String cellval = cell.getStringCellValue();
            System.out.println(cellval);


                String path =" C:\\Users\\ahmed.mahdy\\Desktop\\ee.xlsx";
                FileInputStream fs = new FileInputStream(path);
                Workbook wb = new XSSFWorkbook(fs);
                Sheet sheet1 = wb.getSheetAt(0);
                int lastRow = sheet1.getLastRowNum();
                for(int i=0; i<=lastRow; i++){
                    Row row = sheet1.getRow(i);
                    Cell cell = row.createCell(2);

                    cell.setCellValue("WriteintoExcel");

                }

                FileOutputStream fos = new FileOutputStream(path);
                wb.write(fos);
                fos.close();
            }

    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {

        //Create an object of File class to open xlsx file

        File file = new File("C:\\Users\\ahmed.mahdy\\Desktop\\ee.xlsx");

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting file name in substring  and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if (fileExtensionName.equals(".xlsx")) {

            //If it is xlsx file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if (fileExtensionName.equals(".xls")) {

            //If it is xls file then create object of HSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }

        //Read sheet inside the workbook by its name

        Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

        //Find number of rows in excel file

        int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

        //Create a loop over all the rows of excel file to read it

        for (int i = 0; i < rowCount + 1; i++) {

            Row row = guru99Sheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue() + "|| ");

            }

            System.out.println();
        }

    }

        //Main function is calling readExcel function to read data from excel file

        public static void main(String... strings) throws IOException {

            //Create an object of ReadGuru99ExcelFile class

            App objExcelFile = new App();

            //Prepare the path of excel file

            String filePath = System.getProperty("C:\\Users\\ahmed.mahdy\\Desktop\\ee.xlsx") ;

            //Call read file method of the class to read data

            objExcelFile.readExcel(filePath, "ee.xlsx", "Sheet1");

        }

    }*/

    public XSSFCell getCell(int row, int column, int sheetIndex,String filepath) throws IOException {
        filePathPartRisk= System.getProperty("user.dir")+"\\DOC\\ee.xlsx";
        //"C:\\Users\\ahmed.mahdy\\Downloads\\com.demo.selenium-master\\Excel\\DOC\\ee.xlsx"
        FileInputStream inputstream = new FileInputStream(filepath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

        XSSFCell cell;
        cell = sheet.getRow(row).getCell(column);
        return cell;
    }

    public int getRowSize( String fileName, int sheetIndex ,String PathFile ) throws IOException {

        File file = new File(PathFile);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        assert workbook != null;
        Sheet sheet = workbook.getSheetAt(sheetIndex);

        int w =sheet.getLastRowNum() - sheet.getFirstRowNum();
        return w;

    }
    public int getExportRowCount( String fileName, int sheetIndex ,String PathFile ) throws IOException {

        File file = new File(PathFile);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        if (fileExtensionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

        assert workbook != null;
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        XSSFCell cell = (XSSFCell) sheet.getRow(4).getCell(0);
        int d=cell.getRowIndex();



        System.out.println("index cell ="+d);
        int l = sheet.getPhysicalNumberOfRows();
        return l-d;


        }


    }






