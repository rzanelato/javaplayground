package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivoCSV {

	public static void main(String[] args) {
		 String csvFile = "/temp/testeExcel.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ";";
	        int count = 0;
	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	            	String[] country = line.split(cvsSplitBy);
	            	if (count == 0) {
	            		System.out.println("CABEÇALHO");
	            		System.out.println("testeExcel.csv [sociedad= " + country[0] + " , identificador=" + country[1] + "]");
	            		System.out.println("Info:");
	            	} else {
	            		System.out.println("testeExcel.csv [sociedad= " + country[0] + " , identificador=" + country[1] + "]");
	            	}
	            	count++;

	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}

}
