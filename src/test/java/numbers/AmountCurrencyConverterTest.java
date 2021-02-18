package numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountCurrencyConverterTest {

    private static final String DOLLAR = "USD";
    private static final String REAL = "BRL";
    private static final String EURO = "EUR";
    private static final String YEN = "JPY";

    private static final int INT_VALUE1 = 1265;
    private static final int INT_VALUE2 = 999;
    private static final int INT_VALUE3 = 1000;

    private BigDecimal value1;
    private BigDecimal value2;
    private BigDecimal value3;

    private AmountCurrencyConverter converter;

    @BeforeEach
    void startup() {
        value1 = new BigDecimal("12.65");
        value2 = new BigDecimal("9.99");
        value3 = new BigDecimal("10.00");
    }

    @AfterEach
    void cleanup() {
        value1 = null;
        value2 = null;
        value3 = null;
    }

    @Test
    void shouldReturnOK_toBigDecimal_Dollar1() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE1, DOLLAR);

        assertEquals(value1, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Dollar2() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE2, DOLLAR);

        assertEquals(value2, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Dollar3() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE3, DOLLAR);

        assertEquals(value3, result);
    }

    @Test
    void shouldReturnOK_toInteger_Dollar1() {
        int result = AmountCurrencyConverter.toInteger(value1, DOLLAR);

        assertEquals(INT_VALUE1, result);
    }

    @Test
    void shouldReturnOK_toInteger_Dollar2() {
        int result = AmountCurrencyConverter.toInteger(value2, DOLLAR);

        assertEquals(INT_VALUE2, result);
    }

    @Test
    void shouldReturnOK_toInteger_Dollar3() {
        int result = AmountCurrencyConverter.toInteger(value3, DOLLAR);

        assertEquals(INT_VALUE3, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Real1() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE1, REAL);

        assertEquals(value1, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Real2() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE2, REAL);

        assertEquals(value2, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Real3() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE3, REAL);

        assertEquals(value3, result);
    }

    @Test
    void shouldReturnOK_toInteger_Real1() {
        int result = AmountCurrencyConverter.toInteger(value1, REAL);

        assertEquals(INT_VALUE1, result);
    }

    @Test
    void shouldReturnOK_toInteger_Real2() {
        int result = AmountCurrencyConverter.toInteger(value2, REAL);

        assertEquals(INT_VALUE2, result);
    }

    @Test
    void shouldReturnOK_toInteger_Real3() {
        int result = AmountCurrencyConverter.toInteger(value3, REAL);

        assertEquals(INT_VALUE3, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Euro1() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE1, EURO);

        assertEquals(value1, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Euro2() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE2, EURO);

        assertEquals(value2, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Euro3() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE3, EURO);

        assertEquals(value3, result);
    }

    @Test
    void shouldReturnOK_toInteger_Euro1() {
        int result = AmountCurrencyConverter.toInteger(value1, EURO);

        assertEquals(INT_VALUE1, result);
    }

    @Test
    void shouldReturnOK_toInteger_Euro2() {
        int result = AmountCurrencyConverter.toInteger(value2, EURO);

        assertEquals(INT_VALUE2, result);
    }

    @Test
    void shouldReturnOK_toInteger_Euro3() {
        int result = AmountCurrencyConverter.toInteger(value3, EURO);

        assertEquals(INT_VALUE3, result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Yen1() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE1, YEN);

        assertEquals(BigDecimal.valueOf(INT_VALUE1), result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Yen2() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE2, YEN);

        assertEquals(BigDecimal.valueOf(INT_VALUE2), result);
    }

    @Test
    void shouldReturnOK_toBigDecimal_Yen3() {
        BigDecimal result = AmountCurrencyConverter.toBigDecimal(INT_VALUE3, YEN);

        assertEquals(BigDecimal.valueOf(INT_VALUE3), result);
    }

    @Test
    void shouldReturnOK_toInteger_Yen1() {
        int result = AmountCurrencyConverter.toInteger(BigDecimal.valueOf(INT_VALUE1), YEN);

        assertEquals(INT_VALUE1, result);
    }

    @Test
    void shouldReturnOK_toInteger_Yen2() {
        int result = AmountCurrencyConverter.toInteger(BigDecimal.valueOf(INT_VALUE2), YEN);

        assertEquals(INT_VALUE2, result);
    }

    @Test
    void shouldReturnOK_toInteger_Yen3() {
        int result = AmountCurrencyConverter.toInteger(BigDecimal.valueOf(INT_VALUE3), YEN);

        assertEquals(INT_VALUE3, result);
    }

}
