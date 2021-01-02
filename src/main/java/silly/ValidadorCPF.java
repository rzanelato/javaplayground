package silly;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class ValidadorCPF {
    
    private String cpf;

    public ValidadorCPF(String cpf) {
        this.cpf = normalizarCPF(cpf);
    }
    
    private String normalizarCPF(String cpf) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(cpf);
        String cpfLimpo = "";
        while (matcher.find()) {
            cpfLimpo += matcher.group();
        }
        return cpfLimpo;
    }
    
    private void validarCPF(String cpf) {
        Optional.ofNullable(cpf)
            .map(String::length)
            .filter(length -> length == 11)
            .orElseThrow(() -> new RuntimeException("CPF necessita ter 11 digitos."));
        
    }
    
    private String calcularDigito(String cpf) {
        String cpfSemDigito = cpf.substring(0, 9);
        String digito1 = getDigito(cpfSemDigito);

        String cpfParaDigito2 = gerarCpfParaDigito2(cpfSemDigito, digito1);
        String digito2 = getDigito(cpfParaDigito2);
        
        return digito1.concat(digito2);
    }

    private String getDigito(String cpf) {
        int somaDigito = IntStream.range(1, 10).map(index -> multiplicarDigitoPorIndex(cpf, index)).sum();
        return String.valueOf(somaDigito % 11 % 10);
    }

    private int multiplicarDigitoPorIndex(String cpf, int index) {
        return Integer.valueOf(cpf.substring(index - 1, index)) * index;
    }

    private String gerarCpfParaDigito2(String cpfSemDigito, String digito1) {
        return cpfSemDigito.concat(digito1).substring(1);
    }

    public boolean isValid() {
        validarCPF(cpf);
        String digito = calcularDigito(cpf);
        String digitoCPF = cpf.substring(cpf.length() - 2);
        
        return digito.equals(digitoCPF);
        
    }

    public String cpfFormatado() {
        return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public String cpfFormatado1() {
        return new StringBuilder()
                .append(cpf.substring(0, 3)).append(".")
                .append(cpf.substring(3, 6)).append(".")                
                .append(cpf.substring(6, 9)) .append("-")                
                .append(cpf.substring(9, 11)).toString();
    }

    public String cpfFormatado2() {
        return new StringBuilder(cpf)
                .insert(3, ".")
                .insert(7, ".")                
                .insert(11, "-").toString();
    }

    public static void main(String args[]) {
        ValidadorCPF validador = new ValidadorCPF("303.282.38899");
        System.out.println("CPF \'" + validador.cpfFormatado() + "\' = " + validador.isValid());
    }


}
