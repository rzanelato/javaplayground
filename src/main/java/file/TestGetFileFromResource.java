package file;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestGetFileFromResource {

    public static void main(String[] args) {
        boolean isReadable = Files.isReadable(Paths.get(System.getProperty("user.dir") + "/resources/css/img/icon-excel.png"));
        System.out.println("System.property: " + System.getProperty("user.dir"));
        System.out.println("isReadable: " + isReadable);
        
    }

}
