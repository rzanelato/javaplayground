package webservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.InvalidCurrencyCodeException;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pojo.CurrencyData;

import java.util.Optional;

public class WebServiceWebClient {

    private WebServiceWebClient() {
    }

    public static void main(String[] args) {
        CurrencyData data = WebServiceWebClient.getCurrency("EUR", "USD");
        System.out.println(data);
    }

    public static CurrencyData getCurrency(String codeCurrencySource, String codeCurrencyTarget) {
        validate(codeCurrencySource, codeCurrencyTarget);
        String result = CurrencyWebService.getExchange(codeCurrencySource, codeCurrencyTarget);
        return convertToCurrency(result);
    }

    private static void validate(String sourceCode, String targetCode) {
        validateCode(sourceCode);
        validateCode(targetCode);
    }

    private static void validateCode(String code) {
        Optional.ofNullable(code)
                .filter(codeSize -> codeSize.length() == 3)
                .orElseThrow(InvalidCurrencyCodeException::new);
    }

    private static CurrencyData convertToCurrency(String json) {
        try {
            return new ObjectMapper().readValue(json, CurrencyData.class);
        } catch (JsonProcessingException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private static class CurrencyWebService {

        private static final String BASE_URL = "https://api.exchangeratesapi.io";

        private static WebClient getInstance() {
            return WebClient.builder()
                    .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .baseUrl(BASE_URL)
                    .build();
        }

        public static String getExchange(String source, String target) {
            WebClient.ResponseSpec result = getInstance().get().uri(
                    uriBuilder -> uriBuilder.path("/latest")
                            .queryParam("base", source)
                            .queryParam("symbols", target)
                            .build(1)
            ).retrieve();
            return result.bodyToMono(String.class).block();
        }
    }
}
