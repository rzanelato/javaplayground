package file;

import java.io.File;
import java.net.URL;
import com.github.axet.vget.VGet;

public class YTDowloader {

	public static void main(String[] args) {
        try {
            String url = "https://www.youtube.com/watch?v=K_yBUfMGvzc";
            String path = "/batch/";
            VGet v = new VGet(new URL(url), new File(path));
            System.out.println("Start");
            v.download();
            System.out.println("Finished");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
