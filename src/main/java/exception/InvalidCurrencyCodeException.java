package exception;

public class InvalidCurrencyCodeException extends RuntimeException {

    public InvalidCurrencyCodeException() {
       super("Currency code is not valid.");
    }
}
