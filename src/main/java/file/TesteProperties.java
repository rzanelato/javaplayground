package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TesteProperties {

	private Properties prop;
	public TesteProperties() {
		init();
	}

	private void init() {
		try {
			if (prop == null) {
				prop= new Properties();
				String propFileName = "properties.prop";
				InputStream fileProp = getClass().getClassLoader().getResourceAsStream(propFileName);

				if (fileProp != null) {
					prop.load(fileProp);
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getLoginUrl() {
		return prop.getProperty("login.url");
	}

	public String getLoginProxy() {
		return prop.getProperty("login.proxy");
	}

	public static void main(String[] args) {
		TesteProperties teste = new TesteProperties();
		System.out.println("URL: " + teste.getLoginUrl());
		System.out.println("Proxy: " + teste.getLoginProxy());
	}

}
