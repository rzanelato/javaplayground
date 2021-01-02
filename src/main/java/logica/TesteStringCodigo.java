package logica;

import java.util.Arrays;
import java.util.List;

public class TesteStringCodigo {

	public static void main(String[] args) {
		String error = "MIF0123456654";
		
		String app = getApp(error);
		String desc = getDesc(error);
		
		System.out.println("App: "+app+" desc: "+desc);
	}

	private static String getApp(String error) {
		String[] apps = new String[]{"MIF","BPR","FCH"};
		List<String> listApps = Arrays.asList(apps);
		String app = error.substring(0,3);
		
		if (listApps.contains(app)) {
			return app;
		}
		return "GBP";
	}

	private static String getDesc(String error) {
		String[] apps = new String[]{"MIF","BPR","FCH"};
		List<String> listApps = Arrays.asList(apps);
		String app = error.substring(0,3);
		
		if (listApps.contains(app)) {
			return error.substring(3);
		}
		return error;
	}
	
}
