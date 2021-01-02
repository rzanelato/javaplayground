package file;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import pojo.BeanTest;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Color.BLACK;
import static org.apache.poi.ss.usermodel.BorderStyle.THIN;

public class GerarArquivoExcelConPOI {

	public static void main(String[] args) throws Exception {
		List<BeanTest> lista = new ArrayList<BeanTest>();
		
		BeanTest bean1 = new BeanTest();
		bean1.setNombre("Renato");
		bean1.setNumero(89);
		bean1.setLinea("42");
		BeanTest bean2 = new BeanTest();
		bean2.setNombre("Roberto");
		bean2.setNumero(90);
		bean2.setLinea("66");
		BeanTest bean3 = new BeanTest();
		bean3.setNombre("Ricardo");
		bean3.setNumero(70);
		bean3.setLinea("2");
		BeanTest bean4 = new BeanTest();
		bean4.setNombre("Ronald");
		bean4.setNumero(88);
		bean4.setLinea("4");
		lista.add(bean1);
		lista.add(bean2);
		lista.add(bean3);
		lista.add(bean4);
		
		GerarArquivoExcelConPOI gera = new GerarArquivoExcelConPOI();
		gera.buildExcelDocument(lista);

	}
	
	protected void buildExcelDocument(List<BeanTest> lista) throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("ExcelTeste");
		
		XSSFRow header = sheet.createRow(0);
		int colsNumHeader = 0;
		header.createCell(colsNumHeader++).setCellValue("Nome");
		header.createCell(colsNumHeader++).setCellValue("Numero");
		header.createCell(colsNumHeader++).setCellValue("Linha");
		
		for (Cell cell : header) {
			cell.setCellStyle(getRowStyle(workbook));
		}
		
		int rowNum = 1;
		for (BeanTest imagen : lista) {
			//create the row data
			int colsNumRows = 0;
			XSSFRow row = sheet.createRow(rowNum++);
			row.createCell(colsNumRows++).setCellValue(imagen.getNombre());
			row.createCell(colsNumRows++).setCellValue(imagen.getNumero());
			row.createCell(colsNumRows++).setCellValue(imagen.getLinea());

        }
		System.out.println(colsNumHeader);
		setAutoSizeCells(sheet, colsNumHeader);
		System.out.println(rowNum);
		
		
		FileOutputStream outputStream = new FileOutputStream("/temp/JavaBooks.xlsx"); 
		workbook.write(outputStream);
	}

	private XSSFCellStyle getRowStyle(XSSFWorkbook wb) {
		XSSFColor colorBlack = new XSSFColor(BLACK);

		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style.setBorderBottom(THIN);
		style.setBorderLeft(THIN);
		style.setBorderRight(THIN);
		style.setBorderTop(THIN);
		//style.setBottomBorderColor(colorBlack);
		//style.setLeftBorderColor(colorBlack);
		//style.setRightBorderColor(colorBlack);
		//style.setTopBorderColor(colorBlack);

		return style;
	}
	
	private void setAutoSizeCells(XSSFSheet sheet, int totalCols) {
		for (int index = 0; index < totalCols; index++) {
			sheet.autoSizeColumn(index);
		}
	}

}
