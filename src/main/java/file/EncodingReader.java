package file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EncodingReader {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        String s;

        List<String> filesNames = new ArrayList<>();
        filesNames.add("Import FR - CP12.csv");
        filesNames.add("Import FR - ISO.csv");
        filesNames.add("Import FR - ISO2.csv");
        filesNames.add("Import FR - UTF8.csv");
        filesNames.add("Import FR - WIN.csv");
        filesNames.add("text.txt");

        for (String fileName : filesNames) {
            try {
                // new input stream reader is created 
                fis = new FileInputStream("C:/test/"+fileName);
                isr = new InputStreamReader(fis);

                // the name of the character encoding returned
                s = isr.getEncoding();
                System.out.println(fileName + " ->\t Encoding: " + s);

            } catch (Exception e) {
                // print error
                System.out.print("The stream is already closed");
            } finally {
                // closes the stream and releases resources associated
                if(fis!=null)
                    fis.close();
                if(isr!=null)
                    isr.close();
            }   

        }
    }

}
