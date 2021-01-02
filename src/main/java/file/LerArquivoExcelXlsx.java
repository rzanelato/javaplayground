package file;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LerArquivoExcelXlsx {

	public static void main(String[] args) throws Exception {
		 String excelFilePath = "/temp/testExcel.xlsx";
	        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	         
	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet firstSheet = workbook.getSheetAt(3);
	        System.out.println("Quantidade " + workbook.getNumberOfSheets());
	        System.out.println("Sheet: "+ workbook.getSheetAt(3).getSheetName());
	        Iterator<Row> iterator = firstSheet.iterator();
	         
	        while (iterator.hasNext()) {
	            Row nextRow = iterator.next();
	            Iterator<Cell> cellIterator = nextRow.cellIterator();
	             
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                System.out.print(cell.toString());
	                System.out.print(" - ");
	            }
	            System.out.println();
	        }
	         
	        inputStream.close();
	}

}
