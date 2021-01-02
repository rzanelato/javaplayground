package silly;

import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class GeradorCPF {
    
    private static String normalizarCPF(String cpf) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(cpf);
        
        String cpfLimpo = "";
        while (matcher.find()) {
            cpfLimpo += matcher.group();
        }
        return normalizaMinimo(cpfLimpo);
    }
    
    public static String gerarCpf(String cpfParaGerar) {
        String normalizado = normalizarCPF(cpfParaGerar);
        String cpf = normalizado.substring(0, 9);
        
        int digito = IntStream.range(0, 100)
            .filter(index -> new ValidadorCPF(cpf.concat(normalizeNumber(index))).isValid())
            .findFirst()
            .getAsInt();
        
        return new ValidadorCPF(cpf.concat(normalizeNumber(digito))).cpfFormatado();
    }

    private static String normalizaMinimo(String cpf) {
        return Optional.of(cpf)
            .map(String::length)
            .filter(length -> length < 9)
            .map(length -> criarNumerosAleatorios(length, cpf))
            .orElse(cpf);
        
    }
    
    private static String criarNumerosAleatorios(int length, String cpf) {
        String numerosFaltantes = IntStream.range(0, 9 - length)
                .map(valor -> new Random().nextInt(10))
                .collect(StringBuilder::new,            
                        StringBuilder::append,
                        StringBuilder::append)
                   .toString();
        
        System.out.print("Filled -> " + numerosFaltantes + " - ");
        return cpf.concat(numerosFaltantes);
    }
    
    private static String normalizeNumber(int index) {
        return index < 10 ? "0" + index : String.valueOf(index);
    }
    
    public static void main(String[] args) {
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("30328238899"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("307561178901"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("30756117890"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("3075611789"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("307561178"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("30756117"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("3075611"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("307561"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("30756"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("3075"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("307"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("30"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf("3"));
        System.out.println("NewCPF -> " + GeradorCPF.gerarCpf(""));
        
    }
    
}
