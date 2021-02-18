package numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Optional;

public class AmountCurrencyConverter {

    private static final int DECIMAL_BASE = 10;

    public static BigDecimal toBigDecimal(Integer amount, String currencyCode) {
        final BigDecimal divisor = getBigDecimalFractionByCurrency(currencyCode);
        return new BigDecimal(amount).divide(divisor, getFractionByCode(currencyCode), RoundingMode.HALF_UP);
    }

    public static int toInteger(BigDecimal amount, String currencyCode) {
        final BigDecimal multiplicand = getBigDecimalFractionByCurrency(currencyCode);
        return amount.multiply(multiplicand).intValue();
    }

    private static Currency getCurrencyByCode(String code) {
        final String upperCurrencyCode = Optional.ofNullable(code).map(String::toUpperCase).orElse(null);
        return Currency.getInstance(upperCurrencyCode);
    }

    private static BigDecimal getBigDecimalFractionByCurrency(String currencyCode) {
        final Currency currency = getCurrencyByCode(currencyCode);
        return BigDecimal.valueOf(Math.pow(DECIMAL_BASE, currency.getDefaultFractionDigits()));
    }

    private static int getFractionByCode(String code) {
        return getCurrencyByCode(code).getDefaultFractionDigits();
    }

}
