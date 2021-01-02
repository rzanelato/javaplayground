package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class TesteTamanhoArquivo {

	public static void main(String[] args) throws IOException {
		File files = new File("D:\\Meus documentos\\_teste");
		
		List<File> testeList = new ArrayList<File>();
		try{
			for (File file : files.listFiles())
				if(!file.isDirectory()){
					FileChannel testeSim = new FileInputStream(file).getChannel(); 
					if(testeSim.size() >= 30000000){
						testeSim.close();
						testeList.add(file);
					}
				}
		}catch(Exception e){
			System.out.println("erro");
		}
		
		
		for (File novo:testeList){
			if(novo.renameTo(new File("D:\\Meus documentos\\_teste\\pasta teste\\"+novo.getName()))){
				System.out.println("foi");
			}else
				System.out.println("nao foi");
			
		}

		
		
		
	}
}


