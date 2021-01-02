package web;

import java.io.IOException;

import org.jsoup.Jsoup;

public class LerPaginaWebJSoup {

	public static void main(String[] args) throws IOException {
		//System.setProperty("http.proxyHost", "10.129.8.100");
		//System.setProperty("http.proxyPort", "8080");
		
		String webPage = "https://es.yahoo.com/?p=us";
        
        String html = Jsoup.connect(webPage).get().html();
        
        System.out.println(html);
	}
}