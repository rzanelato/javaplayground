package logic;

public class TesteClasseFilho extends TesteClassePai {

    public void executeMethod() {
        super.executeMethod();
        System.out.println("executa classe filho");
    }
    
    public static void main(String[] args) {
        TesteClassePai filho = new TesteClasseFilho();
        filho.executeMethod();
        System.out.println(filho.toString());
        
    }
    
    public String toString() {
        return "toString Filho " + super.toString();
    }
}
