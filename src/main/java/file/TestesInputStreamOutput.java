package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestesInputStreamOutput {

    public static void main(String[] args) throws Exception {
        //File file = new File("c:/test/Convert.csv");
        File file = new File("c:/test/NL_exporter.dutch-dut-BE.XLSX");
        InputStream inputStream = new FileInputStream(file);
        
        File newFile = convertInputStreamToFile(inputStream);
        
        System.out.println("Name: " + file.getName());
        String fileName = getFileExtension(file.getName());
        System.out.println("Extension: " + fileName);
    }

    private static File convertInputStreamToFile(InputStream inputStream) {
        //Outpu fileOutputStream;
        
        
        
        
        
        
        
        return null;
    }

    private static String getFileExtension(String fileName) {
        String lastLetters = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        return lastLetters;
    }
    
}
