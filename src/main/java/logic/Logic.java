package logic;

public class Logic {
    
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = false;
        
        boolean result = b1 || b2 && b3;
        System.out.println("Result: " + result);
        
        result = b1 || (b2 && b3);
        System.out.println("Result: " + result);
    }

}
