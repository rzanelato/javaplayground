package logic;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodingTest {

    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        String url="https%3A%2F%2Fr1---sn-ci5gup-cags.googlevideo.com%2Fvideoplayback%3Fpcm2cms%3Dyes%26mime%3Dvideo%252Fmp4%26pl%3D21%26itag%3D22%26\u0026itag=43\u0026type=video%2Fwebm%3B+codecs%3D%22vp8.0%2C+vorbis%22\u0026quality=medium";  
        String url2="https://r1---sn-ci5gup-cags.googlevideo.com/videoplayback?pcm2cms=yes&mime=video/mp4&pl=21&itag=22&&itag=43&type=video/webm; codecs=\"vp8.0, vorbis\"&quality=medium";  
        String decodeURL = decode(url);  
        System.out.println("Decoded URL: "+decodeURL);  
        String encodeURL = encode(url2);  
        System.out.println("Encoded URL2: "+encodeURL);  
        System.out.println();
        String testeEncoding = "µáéíóú";
        String testeEncodeUTF8 = "75µg 4% - µaáeéiíoóuú";
        System.out.println("MeuTest : " + encode(testeEncoding));
        //System.out.println("Decode: "+decode("25%25"));
        System.out.println("Decode: "+decode(testeEncoding));
        
        System.out.println("Test: "+encode("sidePanelForm.xhtml?idForm="));
        System.out.println("Test: "+encode("operation=INSERT&isIframe=true&sidePanel=CENTERRIGHT"));
        System.out.println("Test: "+encode("/dtf-webapp/view/"));
        System.out.println("Test: "+encode("?idView="));
        
        System.out.println("encode: " + encode(testeEncodeUTF8));
        String resultCP = encode(testeEncodeUTF8);
        System.out.println("decode: " + decode(resultCP));
        
        
        System.out.println("encodeUTF8: " + encodeUTF8(testeEncodeUTF8));
        System.out.println("encodeUTF8: " + encodeUTF8("µ %"));
        String resultUTF8 = encodeUTF8(testeEncodeUTF8);
        System.out.println("decodeUTF8: " + decodeUTF8(resultUTF8));
        
        System.out.println("\nCruzado");
        System.out.println("encode: " + encodeUTF8(testeEncodeUTF8));
        System.out.println("decode: " + decode(resultUTF8));
        String result = encode(testeEncodeUTF8);
        System.out.println("encodeUTF8: " + encode(testeEncodeUTF8));
        System.out.println("decodeUTF8: " + decodeUTF8(result));
        
    }

    public static String encode(String url) {  
        try {  
            if (url.contains("%")) {
                
            }
            String encodeURL = URLEncoder.encode( url, "CP1252" );  
            return encodeURL;  
        } catch (UnsupportedEncodingException e) {  
            return "Issue while encoding" +e.getMessage();  
        }  
    }
    
    public static String encodeUTF8(String url) {  
        try {  
            String encodeURL = URLEncoder.encode( url, "UTF8" );  
            return encodeURL;  
        } catch (UnsupportedEncodingException e) {  
            return "Issue while encoding" +e.getMessage();  
        }  
    }

    public static String decode(String url) {  
        try {  
            String decodeURL = URLDecoder.decode(url, "CP1252");  
            return decodeURL;  
        } catch (UnsupportedEncodingException e) {  
            return "Issue while decoding" +e.getMessage();  
        }  
    }
    
    public static String decodeUTF8(String url) {  
        try {  
            /*
            String prevURL="";  
            String decodeURL=url;  
            while(!prevURL.equals(decodeURL)) {  
                prevURL = decodeURL;  
                decodeURL = URLDecoder.decode( decodeURL, "UTF8" );  
            }*/
            
            String decodeURL = URLDecoder.decode(url,"UTF-8");  
            return decodeURL;  
        } catch (UnsupportedEncodingException e) {  
            return "Issue while decoding" +e.getMessage();  
        }  
    }


}
