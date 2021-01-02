package log4j;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class TesteLog4jArquivoXml {
	
    static Logger logger = Logger.getLogger(TesteLog4jArquivoXml.class);
	
	public static void main(String[] args) {
		TesteLog4jArquivoXml teste = new TesteLog4jArquivoXml();
		teste.init();
    }

	
	public void init() {
        String log4jConfigFile = "src/resources/log4j.xml";
        File file = new File(log4jConfigFile);
        
        DOMConfigurator.configure(file.getAbsolutePath());
        
 
        logger.info("this is a information log message");
        logger.debug("this is a debug log message");
        logger.warn("this is a warning log message");
        
        logger.debug("Debug:");
	}
}
