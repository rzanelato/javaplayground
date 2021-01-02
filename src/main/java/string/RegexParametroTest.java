package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.poifs.filesystem.EntryUtils;
import org.apache.poi.util.StringUtil;

public class RegexParametroTest {

    private static final String REGEX_ANY_PARAMETER_HASH = "\\#([^\\#]+)\\#";
    
    public static void main(String[] args) {
        //regexEmTexto();
        
        
        //String regex = "[a-z]{4}([a-z]{3})[a-z]*";
        //System.out.println("abcdefghijklmnop".replaceFirst(regex, "$1"));

        Map<String, String> params = getParams();
        
        for (Entry<String, String> param : params.entrySet()) {
            System.out.println("["+param.getKey()+ "] -" + param.getValue());
        }
        
        for (Entry<String, String> param : params.entrySet()) {
            String key = "#"+param.getKey().substring(1).toLowerCase()+"#";
            System.out.println(key +" - " + param.getValue());
        }
        
    }

    
    private static void regexEmTexto() {
        
        String texto = "#coco#hsjhsjshjs/* ?#filterKey#? [\r\n" + 
                "    and per.PER_ID = #filterKey#\r\n" + 
                "    rola na #bunda#] */";
        String text = "SELECT per.PER_ID AS CODE, stk_comun_pkg.nombre_apellidos_en(PER.NOMBRE,PER.APELLIDO1,PER.APELLIDO2)  AS VALUE\r\n"+
                "   FROM STK_PERSONAS per\r\n" + 
                "   LEFT OUTER JOIN STK_PAC_EN_CENTRO paccen ON per.PER_ID = paccen.PAC_ID\r\n"+
                "   WHERE 1=1\r\n"+
                "   /* ?#filterKey#? [\r\n" +
                "   and per.PER_ID = #filterKey#\r\n"+
                "   ] */\r\n"+
                "   /* ?#filterNormal#? [\r\n"+
                "   AND CONTAINS(OTX_UPD_FLG,#filterNormal#||'%') > 0\r\n"+ 
                "   ] */\r\n"+
                "   AND paccen.CEN_ID IN (#groupCenterHierarchyTreeList#)\r\n"+
                "   AND per.FECHA_BAJA is NULL";
        
        setValueRegex(REGEX_ANY_PARAMETER_HASH, texto);
        System.out.println("\n######################################################\n");
        System.out.println("$LOCALE".substring(1));
    }
    
    private static void setValueRegex(String regex, String texto) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);
        String returnText = "";

        while (m.find()) {
            returnText += m.group(1)+",";
        }
        System.out.println("return: "+returnText);
        System.out.println("\n######################################################\n");
    }
    
    private String getHashParameters(String sql) {
        Pattern p = Pattern.compile(REGEX_ANY_PARAMETER_HASH);
        Matcher m = p.matcher(sql);
        String returnText = "";

        while (m.find()) {
            returnText += m.group(1)+";";
        }
        return returnText;
    }
    
    private static Map<String, String> getParams() {
        Map<String, String> params = new HashMap();
        for (int i = 1 ; i < 10 ; i++) {
            params.put("$BB"+i, "V"+i*9);
        }
        return params;
    }
    
    private String replaceSystemParamsHash(String sql) {
        if(sql != null && !"".equals(sql) && !" ".equals(sql)) {
            for(Map.Entry<String, String> param : getParams().entrySet()){
                String key = "#"+param.getKey().substring(1).toLowerCase()+"#";
                sql= StringUtils.replace(sql, key, param.getValue());
            }
        }
        return sql;
    }
    
    
}
