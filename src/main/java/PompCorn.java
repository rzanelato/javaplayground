import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PompCorn {

    public static void main(String[] args) {
        PompCorn pom = new PompCorn();
        pom.execute();
    }
    
    public void execute() {
        String file = VersionChanger.filePathToString("");
    }
    
    private static class VersionChanger {
        static String filePathToString(String path) {
            try {
                FileInputStream inputStrem = new FileInputStream(new File(path));
            } catch (FileNotFoundException dnfe) {
                System.out.println("FileNotFoundException: " + dnfe.getMessage());
            }
            return "";
        }
        
    }

}
