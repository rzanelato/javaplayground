package file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;


public class TestListCharsetDetector {
    
    public static void main(String[] args) {
//        File file = new File("C:\\Users\\rzanelato\\AppData\\Local\\Temp\\");
        File file = new File("C:/test");
        
        List<File> listFiles = new ArrayList<>();
        for (File f : file.listFiles()) {
            //if (f.getName().endsWith(".csv")) {
                listFiles.add(f);
            //}
        }
        checkListCharset(listFiles);
    }
    

    private static void checkListCharset(List<File> filesNames) {
        String[] charsetsToBeTested = {"UTF-8", "cp1252", "ISO-8859-1", "ISO-8859-2", "windows-1252"};
        TestListCharsetDetector cd = new TestListCharsetDetector();
        String strCharset;
        
        for (File file : filesNames) {
            Charset charset = cd.detectCharset(file, charsetsToBeTested);
            
            if (charset == null) {
                strCharset = "Unrecognized charset.";
            } else {
                strCharset = charset.toString();
            }
            System.out.println(file.getName() + " ->\t Encoding: " + strCharset);
        }
    }
    
    private Charset detectCharset(File f, String[] charsets) {
 
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

}