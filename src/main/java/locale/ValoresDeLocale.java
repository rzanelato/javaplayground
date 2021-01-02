package locale;

import java.util.Locale;
import java.util.TimeZone;

public class ValoresDeLocale {
    
    public static void main(String[] args) {
        Locale locale = new Locale("es", "es");
        
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());
        
        System.out.println("== TIMEZONE ==");
        TimeZone timezone = TimeZone.getDefault();
        System.out.println(timezone.getDisplayName());
        System.out.println(timezone.getID());
        
        TimeZone timezone1 = TimeZone.getTimeZone("GMT");
        System.out.println(timezone1.getDisplayName());
        System.out.println(timezone1.getID());
        
        TimeZone timezone2 = TimeZone.getTimeZone("America/Santiago");
        System.out.println(timezone2.getDisplayName());
        System.out.println(timezone2.getID());
        

        
    }

}
