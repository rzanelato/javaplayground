package file;

import java.util.Arrays;

public class TestFileExtension {

    public static void main(String[] args) {
        String teste = "fileTest.pdf";
        
        System.out.println("Test: " + FileExtension.getFileExtensionName1(teste));
        System.out.println("TestExtension: " + isFileNoImage(teste));
        System.out.println("user.dir: " + System.getProperty("user.dir"));
        
        
    }
    
    private static boolean isFileNoImage(String filename) {
        String fileExtension = filename.substring(filename.lastIndexOf(".")+1);
        return Arrays.stream(FileExtension.values()).anyMatch(fileExt -> fileExt.getExtension().equals(fileExtension));
    }
    
    enum FileExtension {
        DOC("doc","word"),
        DOCX("docx","word"),
        XLS("xls","excel"),
        XLSX("xls","excel"),
        TXT("txt","txt"),
        PDF("pdf","pdf");
        
        private String extension;
        private String imgName;
        
        private FileExtension(String extension, String imgName) {
            this.extension = extension;
            this.imgName = imgName;
        }
        
        public String getExtension() {
            return this.extension;
        }
        
        public String getImgName() {
            return "img-" + this.imgName + ".png";
        }
        
        public static String getFileExtensionName(String filename) {
            String auxExt = filename.substring(filename.lastIndexOf(".")+1);
            for (FileExtension fe : FileExtension.values()) {
                if (fe.getExtension().equals(auxExt)) {
                    return fe.getImgName(); 
                }
            }
            return "img-txt.png"; 
        }
        
        public static String getFileExtensionName1(String filename) {
            String auxExt1 = filename.substring(filename.lastIndexOf(".")+1);
            System.out.println("Ext: " + auxExt1);
            return Arrays.stream(FileExtension.values()).filter(fileExt -> fileExt.getExtension().equals(auxExt1)).findAny().orElse(TXT).getImgName(); 
        }
    }
    
}
