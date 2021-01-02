package string;

import java.util.Arrays;
import java.util.List;

public class TestListString {

    public static void main(String[] args) {
        System.out.println("Existe: " + isImageFile("fileTeste.gif"));

    }

    private static boolean isImageFile(String filename) {
        List<String> list = Arrays.asList("jpg" ,"jpeg" ,"gif" ,"png");
        return list.contains(filename.substring(filename.lastIndexOf(".")+1));
    }
}
