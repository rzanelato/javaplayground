package silly;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class CardValidator {

	private enum CardsTest {
		CARD1("4766 6300 7034 8024"),
		CARD2("4350 4401 3795 0784"),
		CARD1_REDUCED("4766630070348024"),
		CARD2_REDUCED("4350440137950784");

		private final String card;

		CardsTest(String card) {
			this.card = card;
		}

		public String getValue() {
			return card;
		}
	}
	
	public static void main(String[] args) {
		Stream.of(CardsTest.values())
				.map(CardsTest::getValue)
				.forEach(card -> {
					showConsole("Card: " + card);
					//semi refactoring
					showConsole("Validate: " + validate(card));
					// first refactoring
					showConsole("Validate2: " + validate2(card));
					//final refactoring
					showConsole("Validate3: " + validate3(card));
					// original used
					showConsole("validateOriginal: " + validateOriginal(card));
					showConsole("");
				});
	}

	private static void showConsole(String text) {
		System.out.println(text);
	}
	
	private static boolean validate3(final String cardNumber) {
	    return Optional.ofNullable(cardNumber)
                .filter(StringUtils::isNotBlank)
                .map(StringUtils::deleteWhitespace)
                .map(CardValidator::validateCard3)
                .orElse(false);
	}
	
	private static boolean validateCard3(final String number) {
		int[] cardNumbers = getArrayIntFromString(number);
		return isSumDecimal(cardNumbers);
	}

	private static int[] getArrayIntFromString(String number) {
		return Stream.of(number.split(""))
				.map(Integer::parseInt)
				.mapToInt(Integer::intValue)
				.toArray();
	}

	private static boolean isSumDecimal(int[] cardNumbers) {
	    int sum = sumCardNumbers(cardNumbers);
	    return sum % 10 == 0;
	}

    private static int sumCardNumbers(int[] cardNumbers) {
        return IntStream.range(0, cardNumbers.length)
        	            .map(index -> calculateEvenIndex3(index, cardNumbers))
        	            .sum();
    }
	
	private static int calculateEvenIndex3(int index, int[] cardNumbers) {
	    return Optional.of(cardNumbers[index])
	            .filter(cardNumber -> isEvenIndex(index))
	            .map(CardValidator::multiplyEvenIndex)
	            .orElse(cardNumbers[index]);
	}
	
	private static int multiplyEvenIndex(int cardNumber) {
	    Predicate<Integer> isGreaterThanNine = number -> number > 9;
	    int doubleNumber = cardNumber * 2;
	    return Optional.of(doubleNumber)
	                   .filter(isGreaterThanNine)
	                   .map(CardValidator::reduceAndSumDecimal)
	                   .orElse(doubleNumber);
    }
	
	private static int reduceAndSumDecimal(int doubleNumber) {
	    return doubleNumber % 10 + 1;
	}

    private static boolean isEvenIndex(int index) {
	    return index % 2 == 0;
	} 
	
	private static boolean validate(final String cardNumber) {
		return Optional.ofNullable(cardNumber)
					.filter(StringUtils::isNotBlank)
					.map(StringUtils::deleteWhitespace)
					.map(CardValidator::validateCard)
					.orElse(false);
	}
	
	private static boolean validateCard(final String number) {
		int[] cardNumbers = Stream.of(number.split(""))
			.map(Integer::parseInt)
			.mapToInt(Integer::intValue)
			.toArray();

		int sum = IntStream.range(0, cardNumbers.length)
				.map(index -> calculateEvenIndex(index, cardNumbers))
				.sum();
		
        return sum % 10 == 0;
	}
	
	private static int calculateEvenIndex(int index, int[] cardNumbers) {
		if(index % 2 == 0 ) {
			int newValue = cardNumbers[index] * 2;
			if (newValue > 9) {
				newValue = newValue % 10 + 1;
			}
			return newValue;
		}
		return cardNumbers[index];
	}
	
	private static boolean validate2(final String cardNumber) {
		return Optional.ofNullable(cardNumber)
					.filter(StringUtils::isNotBlank)
					.map(StringUtils::deleteWhitespace)
					.map(CardValidator::validateCard2)
					.orElse(false);
	}
	
	private static boolean validateCard2(final String number) {
		int[] cardNumbers = Stream.of(number.split(""))
			.map(Integer::parseInt)
			.mapToInt(Integer::intValue)
			.toArray();

		int evenNumbers = IntStream.iterate(0, index -> index + 2)
							.limit(8)
							.map(index -> {
								int newValue = cardNumbers[index] * 2;
								if (newValue > 9) {
									newValue = newValue % 10 + 1;
								}
								return newValue;
							})
							.sum();
        
        int oddNumbers = IntStream.iterate(1, index -> index + 2)
        		.limit(8)
            	.map(value -> cardNumbers[value])
            	.sum();

        int sum = evenNumbers + oddNumbers;

        return sum % 10 == 0;
	}
	
	
	private static boolean validateOriginal(final String number) {
        if (number.isEmpty()) {
            return false;
        }
        if(number.contains(" ")) {
        	return false;
		}

        //Luhn algorithm to validate card numbers
        int[] ints = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            ints[i] = Integer.parseInt(number.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }

        return sum % 10 == 0;
    }
	
	
}
