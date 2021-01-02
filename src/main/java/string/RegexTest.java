package string;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    
    private static final String QUERY_CONDITION_OPEN_KEY = "?#";
    private static final String QUERY_CONDITION_CLOSE_KEY = "#?";
    
    private static final String REGEX_ANY_CHAR = "[\\s\\S]*?";
    private static final String REGEX_ANY_SPACE = "[\\s]*?";
    private static final String REGEX_COMMA_SEPARATED = "\\S*,\\S*";
    private static final String EMPTY_STRING = "";
    
    private static final String FILTER_KEY = "filterKey";
    private static final String FILTER_NORMAL = "filterNormal";
    
    
    public static void main(String[] args) {
        regexEmTexto();
        //String regex = "[a-z]{4}([a-z]{3})[a-z]*";
        //System.out.println("abcdefghijklmnop".replaceFirst(regex, "$1"));

    }

    
    private static void regexEmTexto() {
        String regex1 = "([\\W]{5}filterKey[\\W]{3}[^\\n])+([\\w\\s.#=])+([^\\n][\\W]{4})";
        
        String texto = "    /* ?#filterKey#? [\r\n" + 
                "    and per.PER_ID = #filterKey#\r\n" + 
                "    ] */";
        String regex = "([\\s\\S]*?)([[/\\*][\\s]*?[\\?#" + "filterKey" + "#\\?][[\\s]*?][\\[]]])([\\s\\S]*?)[\\]][[\\s]*?][\\*/]([\\s\\S]*?)";
        String crd = "[\\s\\S]*?((/\\*)[\\s]*?(\\?#filterKey#\\?)[\\s]*?(\\[)[\\s\\S]*?(#filterKey#)[\\s\\S]*?(\\])[\\s]*?(\\*/))[\\s\\S]*?";
        String rex = "([\\s\\S]*?)((/\\*)[\\s]*?(\\?#filterNormal#\\?)[\\s]*?(\\[)([\\s\\S]*?(#filterNormal#)[\\s\\S]*?)(\\])[\\s]*?(\\*/))[\\s\\S]*?";
        
        String text = "SELECT per.PER_ID AS CODE, stk_comun_pkg.nombre_apellidos_en(PER.NOMBRE,PER.APELLIDO1,PER.APELLIDO2)  AS VALUE\r\n"+
                "   FROM STK_PERSONAS per\r\n" + 
                "   LEFT OUTER JOIN STK_PAC_EN_CENTRO paccen ON per.PER_ID = paccen.PAC_ID\r\n"+
                "   WHERE 1=1\r\n"+
                //"777"+
                "   /* ?#filterNormal#? [\r\n"+
                "   AND CONTAINS(OTX_UPD_FLG,#filterNormal#||'%') > 0\r\n"+ 
                "   ] */\r\n"+
                "   AND paccen.CEN_ID IN (#groupCenterHierarchyTreeList#)\r\n"+
                "   AND per.FECHA_BAJA is NULL" + 
                "   /* ?#filterKey#? [\r\n" +
                "   and per.PER_ID = #filterKey#\r\n"+
                "   ] */\r\n"+
                //"777"+
                "    /* ?#filterNormal#? [\r\n" + 
                "    AND (UPPER(mat.DESCRIPCION) LIKE UPPER('%' || #filterNormal# || '%')) \r\n" + 
                "   ] */\r\n"+
                "   AND paccen.CEN_ID IN (#groupCenterHierarchyTreeList#)\r\n"+
                "   AND per.FECHA_BAJA is NULL" + 
                "    /* ?#filterKey#? [\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    ] */\r\n" + 
                
                "";
        
        String oneText = "SELECT per.PER_ID AS CODE, stk_comun_pkg.nombre_apellidos_en(PER.NOMBRE,PER.APELLIDO1,PER.APELLIDO2)  AS VALUE "+
                "   FROM STK_PERSONAS per " + 
                "   LEFT OUTER JOIN STK_PAC_EN_CENTRO paccen ON per.PER_ID = paccen.PAC_ID "+
                "   WHERE 1=1 "+
                //"777"+
                "   /* ?#filterNormal#? [ "+
                "   AND CONTAINS(OTX_UPD_FLG,#filterNormal#||'%') > 0 "+ 
                "   ] */\r\n"+
                "   AND paccen.CEN_ID IN (#groupCenterHierarchyTreeList#) "+
                "   AND per.FECHA_BAJA is NULL" + 
                "   /* ?#filterKey#? [ " +
                "   and per.PER_ID = #filterKey# "+
                "   ] */ "+
                //"777"+
                "    /* ?#filterNormal#? [ " + 
                "    AND (UPPER(mat.DESCRIPCION) LIKE UPPER('%' || #filterNormal# || '%'))" + 
                "   ] */ "+
                "   AND paccen.CEN_ID IN (#groupCenterHierarchyTreeList#) "+
                "   AND per.FECHA_BAJA is NULL" 
                
                + "   /* ?#filterKey#? [ " +
                "   and per.PER_ID = #filterKey# "+
                "   ] */ "
                
                ;
        String text1 = "SELECT mat.MAT_ID AS CODE, mat.DESCRIPCION  AS VALUE\r\n" + 
                "    FROM STO_MATERIALES mat \r\n" + 
                "    WHERE 1=1\r\n" + 
                "    /* ?#filterKey#? [\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    ] */\r\n" + 
                "    /* ?#filterNormal#? [\r\n" + 
                "    AND (UPPER(mat.DESCRIPCION) LIKE UPPER('%' || #filterNormal# || '%')) \r\n" + 
                "    ] */\r\n" + 
                "    /* ?#filterKey#? [\r\n" + 
                "    and mat.MAT_ID = #filterKey#\r\n" + 
                "    ] */\r\n" + 
                "    AND mat.FECHA_BAJA is NULL";
        
        String another = "SELECT pro.per_id as code, stk_comun_pkg.nombre_apellidos(PER.NOMBRE,PER.APELLIDO1,PER.APELLIDO2) || ' (' || esp.descripcion || ')' AS value\r\n" + 
                "FROM stk_profesionales pro\r\n" + 
                "JOIN stk_personas per ON pro.per_id = per.per_id\r\n" + 
                "join age_agendas age on pro.per_id = age.per_id\r\n" + 
                "JOIN STK_ESPECIALIDADES esp on esp.esp_id = pro.esp_id\r\n" + 
                "WHERE TPR_ID = 1\r\n" + 
                "/* ?#HDAT.CEN_ID#? [\r\n" + 
                "AND age.cen_id = #HDAT.CEN_ID#\r\n" + 
                "] */"+
                "    /* ?#filterNormal#? [\r\n" + 
                "    AND (UPPER(mat.DESCRIPCION) LIKE UPPER('%' || #filterNormal# || '%')) \r\n" + 
                "    ] */\r\n" + 
                "   /* ?#filterKey#? [\r\n" +
                "   and per.PER_ID = #filterKey#\r\n"+
                "   ] */\r\n"+
                "    /* ?#HDAT.CEN_ID#? [\r\n" + 
                "    and mat.MAT_ID = #HDAT.CEN_ID#\r\n" + 
                "    ] */\r\n" + 
                "   /* ?#filterKey#? [\r\n" +
                "   and per.PER_ID = #filterKey#\r\n"+
                "   ] */\r\n"+
                "";
        //System.out.println("regex: " + createRegex("filterKey"));
        //setValueRegex(rex, text, "$1$6");
       // System.out.println("\n######################################################\n");
        //System.out.println("Criado");
        //setValueRegex(createRegex("filterKey"), text, "$1");
        //Pattern pattern = generateRegexPatternToMatchWithQueryConditionFromKey(FILTER_NORMAL);
        //System.out.println(replaceMultipleOccurencesOfPattern(text, FILTER_NORMAL, "valor", pattern));
        
        System.out.println(replaceParamQueryConditionInSQLStmt(text, FILTER_KEY, "999"));
        System.out.println();
        System.out.println(replaceParamQueryConditionInSQLStmt(another, "HDAT.CEN_ID", "Renato"));
        //metodoToscoDeSplitText(text);
        //renatoSolution(text);
        //renatoSolutionAlt(text);
    }
    
    private static void metodoToscoDeSplitText(String text) {
        int index = 0;
        //for (String sss : text.split("\\?#filterNormal#\\?")) {
        for (String sss : text.split("\\?#")) {
            System.out.println("Index["+index+"] :");
            System.out.println("?#"+sss);
            index++; 
        }
        
    }
    
    private static void renatoSolution(String text) {
        List<String> lines = Arrays.asList(text.split(""));
        boolean isBegin = false;
        for (String line : lines) {
            if (line.contains("?#filterNormal#?")) {
                
            }
        }
    }
    
    private static void renatoSolutionAlt(String text) {
        String FILTER = "?#filterNormal#?";
        int filterLenght = FILTER.length();
        int index1 = text.indexOf(FILTER);
        String test = text.substring(0,index1);
        System.out.println(test);
        String test2 = text.substring(index1+filterLenght);

        System.out.println(test2);
        /*while (text.contains(FILTER)) {
        }*/
    }


    private static void setValueRegex(String regex, String texto, String grupo) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);
        String returnText = "";

        while (m.find()) {
            returnText += m.group(3);
        }
        System.out.println("return: "+returnText);
        System.out.println("\n######################################################\n");
        System.out.println("\nreplace: " +texto.replaceFirst(regex, grupo));
    }
    
    
    // 
    private static String createRegex(String key) {
        String regex = ""+REGEX_ANY_CHAR +
        "((/\\*)" + REGEX_ANY_SPACE +
        "(\\?#" + key + "#\\?)" + REGEX_ANY_SPACE +
        "(\\[)" + REGEX_ANY_CHAR +
        "(#" + key + "#)" + REGEX_ANY_CHAR +
        "(\\])" + REGEX_ANY_SPACE +
        "(\\*/))" + REGEX_ANY_CHAR +
        "";
        return regex;
    }
    
    private static Pattern generateRegexPatternToMatchWithQueryConditionFromKey(String key) {
        return Pattern.compile(REGEX_ANY_CHAR +
                "((/\\*)" + REGEX_ANY_SPACE +
                "(\\?#" + key + "#\\?)" + REGEX_ANY_SPACE +
                "(\\[)" + REGEX_ANY_CHAR +
                "(#" + key + "#)" + REGEX_ANY_CHAR +
                "(\\])" + REGEX_ANY_SPACE +
                "(\\*/))" + REGEX_ANY_CHAR);
    }

    private static String replaceParamQueryConditionInSQLStmt(String query, String key, String value) {
        String keyQueryCondition = QUERY_CONDITION_OPEN_KEY + key + QUERY_CONDITION_CLOSE_KEY;
        if (query != null && query.contains(keyQueryCondition)) {
            Pattern pattern = generateRegexPatternToMatchWithQueryConditionFromKey(key);
            return replaceMultipleOccurencesOfPattern(query, keyQueryCondition, value, pattern);
        }

        return query;
    }

    private static String replaceMultipleOccurencesOfPattern(String query, String key, String value, Pattern pattern) {
        String updatedQuery = query;
        for (int i = 0; i < countTotalOccurences(key, updatedQuery); i++) {
            Matcher matcher = pattern.matcher(updatedQuery);
            while (matcher.find()) {
                String groupWithReplacedValues = replaceValueInRegexGroups(value, matcher);
                updatedQuery = updatedQuery.replace(matcher.group(1), groupWithReplacedValues);
            }
        }
        return updatedQuery;
    }

    private static String replaceValueInRegexGroups(String value, Matcher matcher) {
        String newGroup = matcher.group(1);
        newGroup = newGroup.replace(matcher.group(2), EMPTY_STRING);
        newGroup = newGroup.replace(matcher.group(3), EMPTY_STRING);
        newGroup = newGroup.replace(matcher.group(4), EMPTY_STRING);
        newGroup = newGroup.replace(matcher.group(5), "'" + value + "'");
        newGroup = newGroup.replace(matcher.group(6), EMPTY_STRING);
        newGroup = newGroup.replace(matcher.group(7), EMPTY_STRING);
        return newGroup;
    }

    private static int countTotalOccurences(String key, String updatedQuery) {
        return updatedQuery.split(key.replace("?", "\\?"), -1).length - 1;
    }
}
