package thread;

import utils.ConfigDaemon;

public class TestDaemon extends Thread {

    public static void main(String[] args) {

        try {
        	
        	WorkerThread worker = new WorkerThread();
        	worker.start();

        	Thread.sleep(1000*60*2);
        } catch (InterruptedException e) {
            System.out.println("Exception: "+e.getMessage());
        }

        System.out.println("Main Thread ending") ;
    }
}

class WorkerThread extends Thread {

    public WorkerThread() {
        // When false, (i.e. when it's a user thread),
        // the Worker thread continues to run.
        // When true, (i.e. when it's a daemon thread),
        // the Worker thread terminates when the main 
        // thread terminates.
        setDaemon(true); 
    }

    public void run() {
        int count = 0;
        System.out.println("KeepAliveWT: " + ConfigDaemon.isDaemonKeepWorking() );
        ProcesoThread proc = new ProcesoThread();
        proc.start();
        while (true) {
        	if (!proc.isAlive()) {
        		try {
					proc.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		if (!proc.isAlive() && ConfigDaemon.isDaemonKeepWorking()) {
        			proc = new ProcesoThread();
        			proc.start();
        			System.out.println("Inner KeepAliveWT: " + ConfigDaemon.isDaemonKeepWorking() );
        			System.out.println("Hello from WorkerWT "+count++);
        			
        			
        			try {
        				sleep(10000);
        			} catch (InterruptedException e) {
        				// handle exception here
        			}
        			
        		}
        		System.out.println("Terminado WT");
        	}
        }
    }
    
    class ProcesoThread extends Thread {
    	
    	public ProcesoThread() {
    		// When false, (i.e. when it's a user thread),
    		// the Worker thread continues to run.
    		// When true, (i.e. when it's a daemon thread),
    		// the Worker thread terminates when the main 
    		// thread terminates.
    		setDaemon(true); 
    	}
    	
    	public void run() {
    		int count = 0;
    		System.out.println("ProcesoThread.KeepAlive: " + ConfigDaemon.isDaemonKeepWorking() );
    		while (ConfigDaemon.isDaemonKeepWorking()) {
    			System.out.println("Hello from Worker "+count++);

    			try {
    				sleep(2000);
    			} catch (InterruptedException e) {
    				// handle exception here
    			}
    		}
    		this.interrupt();
    		System.out.println("ProcesoThread Fin");
    	}
    }
}
