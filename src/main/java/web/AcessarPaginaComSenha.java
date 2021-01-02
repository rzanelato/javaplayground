package web;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

public class AcessarPaginaComSenha {
    
    public static void main(String[] args) {
        
        HttpClient client = new HttpClient();
        client.getParams().setParameter("j_username", "abc");
        client.getParams().setParameter("j_password", "pqr");
     
        GetMethod method = new GetMethod("http://localhost:8080/");
        try{
          client.executeMethod(method);
          
          client.executeMethod(method);
        } catch(Exception e) {
          System.err.println(e);
        } finally {
          method.releaseConnection();
        }
    }

}
