package logica;

public class PegaValorStringXml {

	public static void main(String[] args) {
		String xml = "<respuesta-login><code>200</code><description></description><token>8ea64404-e9ac-4882-8312-2742f35e232e</token></respuesta-login>";
		
		String retorno = xml.substring(xml.indexOf("<token>")+"<token>".length(), xml.indexOf("</token>"));
		String restoAntes = xml.substring(0,xml.indexOf("<token>")+"<token>".length());
		String restoDepois = xml.substring(xml.indexOf("</token>"));
		
		String xmlParsedBefore = xml.substring(0,xml.indexOf("<token>")+"<token>".length());
		String xmlParsedAfter = xml.substring(xml.indexOf("</token>"));
		
		System.out.println(retorno);
		System.out.println(xmlParsedBefore);
		System.out.println(xmlParsedAfter);
		
	}
}
