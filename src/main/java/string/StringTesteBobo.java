package string;

public class StringTesteBobo {

    public static void main(String[] args) {
        
        testStringFormat();

    }
    
    private static void testStringFormat() {
        System.out.println(String.format("teste %s com argumentos %s e mais %s", 1,2,3));
    }
    
    private static void testeBoboConComa() {
        String str = "0,,1,2,3,5";
        
        System.out.println(str);
        str = str.replaceFirst(",", "");
        System.out.println(str);
        System.out.println(str.contains("0"));
        
        str += "";
        System.out.println(str);
    }

}
