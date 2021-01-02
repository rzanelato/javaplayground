package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;

public class CharsetDetector {
    
    public Charset detectCharset(File f, String[] charsets) {
 
        Charset charset = null;
 
        for (String charsetName : charsets) {
            charset = detectCharset(f, Charset.forName(charsetName));
            if (charset != null) {
                break;
            }
        }
 
        return charset;
    }
 
    private Charset detectCharset(File f, Charset charset) {
        try {
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(f));
 
            CharsetDecoder decoder = charset.newDecoder();
            decoder.reset();
 
            byte[] buffer = new byte[512];
            boolean identified = false;
            while ((input.read(buffer) != -1) && (!identified)) {
                identified = identify(buffer, decoder);
            }
 
            input.close();
 
            if (identified) {
                return charset;
            } else {
                return null;
            }
 
        } catch (Exception e) {
            return null;
        }
    }
 
    private boolean identify(byte[] bytes, CharsetDecoder decoder) {
        try {
            decoder.decode(ByteBuffer.wrap(bytes));
        } catch (CharacterCodingException e) {
            return false;
        }
        return true;
    }
 
    public static void main(String[] args) {
        List<String> filesNames = new ArrayList<>();
        filesNames.add("Import FR - CP12.csv");
        filesNames.add("Import FR - ISO.csv");
        filesNames.add("Import FR - ISO2.csv");
        filesNames.add("Import FR - UTF8.csv");
        filesNames.add("Import FR - WIN.csv");
        filesNames.add("Import FR - NEW.csv");
        filesNames.add("text.txt");
        filesNames.add("text2.txt");
        filesNames.add("text3.txt");
        filesNames.add("NL_exporter.dutch-dut-BE.xlsx");
        filesNames.add("NL_exporter.XLSX");
        filesNames.add("NL_exporter.dutch-dut-BE - Converted.csv");
        filesNames.add("imported.csv");
        
        
        for (String fileName : filesNames) {
            String[] charsetsToBeTested = {"UTF-8", "cp1252", "ISO-8859-1", "ISO-8859-2", "windows-1252", "ANSI"};
            
            CharsetDetector cd = new CharsetDetector();
            File f = new File("c:/test/"+fileName);
            Charset charset = cd.detectCharset(f, charsetsToBeTested);
            System.out.println(fileName + " ->\t Encoding: " + charset);
            
            if (charset != null) {
                try {
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(f), charset);
                    int c = 0;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char)c);
                    }
                    reader.close();
                } catch (FileNotFoundException fnfe) {
                    fnfe.printStackTrace();
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
                
            }else{
                System.out.println("Unrecognized charset.");
            }
        }
 
    }
}