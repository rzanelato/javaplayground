package webservice;

import org.junit.jupiter.api.Test;
import pojo.CurrencyData;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WebServiceWebClientTest {

    private WebServiceWebClient webClient;

    @Test
    void shouldReturnCurrencyEURtoBRL() {

        CurrencyData result = WebServiceWebClient.getCurrency("EUR", "BRL");
        assertNotNull(result);
        //assertEquals("BRL", result.getRates().getCode());
        assertEquals("EUR", result.getBase());
        assertNotNull(result.getDate());
    }
}
