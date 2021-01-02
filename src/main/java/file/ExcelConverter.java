package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConverter {

    public static void main(String[] args) throws IOException {
        // reading file from desktop
        //File inputFile = new File("C:/test/NL_exporter.dutch-dut-BE.xlsx");
        File inputFile = new File("C:/test/Convert.xlsx");
        /*
        System.out.println(inputFile.getAbsoluteFile());
        System.out.println(inputFile.getName());
        System.out.println(inputFile.getName().endsWith(".xlsx"));
        System.out.println(inputFile.getCanonicalPath().toString());
        System.out.println(inputFile.getParent());
        System.out.println(inputFile.getAbsolutePath());
        System.out.println(inputFile.getPath());
        System.out.println(inputFile.getName().replace(".xlsx", "").replace(".xls", ""));
        */
        //File inputFile = new File("C:/test/Convert.xls");
        // writing excel data to csv
        String fileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));
        File outputFile = new File("C:/test/" + fileName + " - Converted.csv");
        convert(inputFile, outputFile);
    }
    
    public static void convert(File inputFile, File outputFile) {
        try {
            FileInputStream fileInStream = new FileInputStream(inputFile);
            XSSFWorkbook wBook = new XSSFWorkbook(fileInStream);
            XSSFSheet sheet = wBook.getSheetAt(0);

            Cell cell;
            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            StringBuilder data = new StringBuilder();
            
            Row row;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    cell = cellIterator.next();

                    switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        data.append("\"" + cell.getStringCellValue().replaceAll("\"", "")+ "\"" + ";");
                        break;

                    case Cell.CELL_TYPE_BLANK:
                        data.append("" + ";");
                        break;
                    default:
                        data.append(cell + ";");

                    }
                }
                data.append("\n");
            }
            
            FileOutputStream fos = new FileOutputStream(outputFile);
            fos.write(data.toString().getBytes());
            fos.close();

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
