package logic;

public class LogicClassNull {

    public static void main(String[] args) {
        PojoTeste pojo1 = new PojoTeste();
        pojo1.setNome("Nome");
        pojo1.setNumero(11);
        
        System.out.println("Pojo1 -" + pojo1.isEmpty());
        
        PojoTeste pojo2 = new PojoTeste("Outro nome", 20);
        System.out.println("Pojo2 -" + pojo2.isEmpty());
        
        PojoTeste pojo4 = new PojoTeste();
        System.out.println("Pojo4 -" + pojo4.isEmpty());

    }
    
    private static class PojoTeste {
        
        private String nome;
        private int numero;
        
        
        public PojoTeste() {
        }

        public PojoTeste(String nome, int numero) {
            super();
            this.nome = nome;
            this.numero = numero;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }
        
        public boolean isEmpty() {
            return this == null || this.getNome() == null || "".equals(this.getNome());
        }

        @Override
        public String toString() {
            return "PojoTeste [nome=" + nome + ", numero=" + numero + "]";
        }
    }

}
