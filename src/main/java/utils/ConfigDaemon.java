package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigDaemon {
	
	private ConfigDaemon() {
	}
	
	public static boolean isDaemonKeepWorking() {
		String propertie = getProperty("daemon.keep.working");
		boolean isActive = propertie.equals("S");
		return isActive;
	}
	
	public static int getTimeInterval() {
		String propertie = getProperty("daemon.time.interval");
		int interval = Integer.parseInt(propertie);
		//return interval * 60000;
		return interval * 1000;
	}
	
	private static String getProperty(String propName) {
		try {
			File file = new File("src/main/resources/configDaemon.properties");
			FileReader freader;
			freader = new FileReader(file);
			
			BufferedReader buffer = new BufferedReader(freader);
			
			List<String> lines = new ArrayList<String>();
			while (buffer.ready()){
				lines.add(buffer.readLine());
			}
			
			freader.close();
			buffer.close();
			
			for (String string : lines) {
				if (string.contains(propName)) {
					String valor = string.substring(string.indexOf("=")+1).trim();
					return valor;
				}
			}
			return "";
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ConfigDaemon.isDaemonKeepWorking());
	}

}