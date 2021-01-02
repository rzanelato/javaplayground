package log4j;

import org.apache.log4j.Logger;

public class ChamarLog4J {

	static Logger logger = Logger.getLogger(ChamarLog4J.class);
	
	public static void main(String[] args) {
		//TesteLog4jArquivoXml log = new TesteLog4jArquivoXml();
		TesteLog4jProperties log = new TesteLog4jProperties();
		log.init();
		logger.debug("Classe de chamada");
		
		TestarJLog4jClasse teste = new TestarJLog4jClasse();
		teste.metodo();
		logger.debug("Classe TestarJLog4jClasse");

	}

}
