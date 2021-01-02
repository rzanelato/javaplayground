package log4j;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;

public class TesteLog4jProperties {

	public void init() {
        String log4jConfigFile = "src/resources/log4j.properties";
        File file = new File(log4jConfigFile);
		PropertyConfigurator.configure(file.getAbsolutePath());
		
		
	}
	
}
