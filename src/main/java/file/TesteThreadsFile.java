package file;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TesteThreadsFile {

	public static void main(String[] args) throws IOException  {
		ExecutorService service = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Iniciou");
		
		TesteMoverFile move = new TesteMoverFile();
		
		//service.execute(move);
		
		metodo(move);
		
	}
	
	private static void metodo(TimerTask task){
		Timer timee = new Timer();
		timee.scheduleAtFixedRate(task, 1000, 10000);
		
		
	
		
	}


}
