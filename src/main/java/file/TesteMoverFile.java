package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class TesteMoverFile extends TimerTask {

	@SuppressWarnings("static-access")
	public void run() {
		List<File> listVideos = new ArrayList<File>(); 
		
		String caminho = "D:\\Meus documentos\\_teste";
		String novoCaminho = "D:\\Meus documentos\\_teste\\Movido";
		
		File[] lista = new File(caminho).listRoots();
		
		
		
		for(File file:lista) {
			//if(file.getName().endsWith(".avi") || file.getName().endsWith(".rmvb")){
				//listVideos.add(file);
				System.out.println(file.getPath());
			//}
		}
		/*
		for(File newFile: listVideos){
			if(newFile.renameTo(new File(novoCaminho+"\\"+newFile.getName())))
				System.out.println("Movido");
			else
				System.out.println("Nao foi");
		}*/
				
		System.out.println("Executou...");
		
	}
	
}
