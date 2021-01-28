package logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    void shouldReturnTenFirstFibonacciWhen_fibonacci_ReceivesNumberTen() {
        int[] expected = new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

        int[] result = Fibonacci.fibonacci(10);

        assertEquals(expected.length, result.length);
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_0() {
        boolean result = Fibonacci.isNumberFibonacci(0);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_1() {
        boolean result = Fibonacci.isNumberFibonacci(1);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_2() {
        boolean result = Fibonacci.isNumberFibonacci(2);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_3() {
        boolean result = Fibonacci.isNumberFibonacci(3);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_5() {
        boolean result = Fibonacci.isNumberFibonacci(5);
        assertTrue(result);
    }

    @Test
    void shouldReturnTrueWhen_isNumberFibonacci_Is_8() {
        boolean result = Fibonacci.isNumberFibonacci(8);
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_4() {
        boolean result = Fibonacci.isNumberFibonacci(4);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_6() {
        boolean result = Fibonacci.isNumberFibonacci(6);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_7() {
        boolean result = Fibonacci.isNumberFibonacci(7);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_9() {
        boolean result = Fibonacci.isNumberFibonacci(9);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_10() {
        boolean result = Fibonacci.isNumberFibonacci(10);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_11() {
        boolean result = Fibonacci.isNumberFibonacci(11);
        assertFalse(result);
    }

    @Test
    void shouldReturnFalseWhen_isNumberFibonacci_Is_12() {
        boolean result = Fibonacci.isNumberFibonacci(12);
        assertFalse(result);
    }

}
