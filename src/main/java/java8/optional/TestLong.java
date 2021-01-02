package java8.optional;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class TestLong {
	
	public static void main(String[] args) throws Exception {
		
		Long valorNulo = null;
		Long comValor = new Long(10);
		
		System.out.println( "Min to Mili (1min) = " + TimeUnit.MINUTES.toMillis(1));
		System.out.println( "Min to Mili (2min) = " + TimeUnit.MINUTES.toMillis(2));
		System.out.println( "Min to Mili (5min) = " + TimeUnit.MINUTES.toMillis(5));
		
		
		System.out.println("Sem Erro " + Optional.ofNullable(valorNulo).filter(Objects::nonNull).orElse(99L));
		System.out.println("Com Erro " + Optional.ofNullable(comValor).filter(Objects::nonNull).orElse(99L));
		System.out.println();
		System.out.println("Sem Erro " + Optional.ofNullable(valorNulo).filter(Objects::nonNull).map(value -> Boolean.FALSE).orElse(true));
		System.out.println("Com Erro " + Optional.ofNullable(comValor).filter(Objects::nonNull).map(value -> Boolean.FALSE).orElse(true));

		System.out.println();
		System.out.println("Sem Erro " + Optional.ofNullable(valorNulo).filter(Objects::nonNull).isPresent());
		System.out.println("Com Erro " + Optional.ofNullable(comValor).filter(Objects::nonNull).isPresent());

		System.out.println();
		System.out.println("Sem Erro " + Optional.ofNullable(valorNulo).isPresent());
		System.out.println("Com Erro " + Optional.ofNullable(comValor).isPresent());
		System.out.println();
		System.out.println("Sem Erro " + Optional.ofNullable(valorNulo).filter(TestLong::isEmpty).orElse(99L));
		System.out.println("Com Erro " + Optional.ofNullable(comValor).filter(TestLong::isEmpty).orElse(99L));
			
	}
	
	private static boolean isEmpty(Long valor) {
		System.out.println(valor);
		System.out.println("isPresent: " + Optional.ofNullable(valor).filter(Objects::nonNull).isPresent());
		System.out.println("!isPresent: " + !Optional.ofNullable(valor).filter(Objects::nonNull).isPresent());
		
		return !Optional.ofNullable(valor).filter(Objects::nonNull).isPresent();
	}
	
	

}
