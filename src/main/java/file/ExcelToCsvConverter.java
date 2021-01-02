package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToCsvConverter {
    
    public static void main(String[] args) {
        try {
            File inputFile = new File("C:/test/Convert.xls");
            String fileName = inputFile.getName();
            String extension = fileName.substring(fileName.lastIndexOf("."), fileName.length()).toLowerCase();
            
            FileInputStream fileInStream = new FileInputStream(inputFile);
            File outputFile = ExcelToCsvConverter.convert(fileInStream, extension);
            System.out.println("File created: " + outputFile.getName());
            outputFile.renameTo(new File("C:/test/Convert - Test_" + extension.replace(".", "") + "_" + System.currentTimeMillis() + ".csv"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File convert(InputStream inputFile, String extension) throws IOException, InvalidFormatException {
        if (".xlsx".equals(extension)) {
            return xlsxToCsv(inputFile);
        } else {
            return xlsToCsv(inputFile); 
        }
    }

    private static File xlsxToCsv(InputStream inputFile) throws IOException, UnsupportedEncodingException, FileNotFoundException {
        XSSFWorkbook wBook = new XSSFWorkbook(inputFile);
        XSSFSheet sheet = wBook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        
        return getCsvFile(rowIterator);
    }
        
    private static File getCsvFile(Iterator<Row> rowIterator) throws IOException {
        Row row;
        Cell cell;
        StringBuilder data = new StringBuilder();

        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                String newCell = cell.getStringCellValue().replaceAll("\"", "").replaceAll(";", ","); 
                data.append("\"" + newCell+ "\"" + ";");
            }
            data.append("\n");
        }
        return createCsvFile(data.toString());
            
    }
    
    private static File createCsvFile(String data) throws IOException {   
        File outputFile = File.createTempFile("importer", ".csv");
        //PrintStream printOutStream = new PrintStream(new FileOutputStream(outputFile), true, StandardCharsets.UTF_8.toString());
        //PrintStream printOutStream = new PrintStream(new FileOutputStream(outputFile));
        PrintStream printOutStream = new PrintStream(new FileOutputStream(outputFile), true, StandardCharsets.ISO_8859_1.toString());
        printOutStream.print(data.toString());
        printOutStream.close();

        return outputFile;        
    }
    
    private static File xlsToCsv(InputStream inputFile) throws InvalidFormatException, IOException {
        Workbook wb = WorkbookFactory.create(inputFile);
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        
        return getCsvFile(rowIterator);
    }
}
