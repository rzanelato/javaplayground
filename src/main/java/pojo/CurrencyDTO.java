package pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

public class CurrencyDTO {
	
	private Map<String, String> rates;
	
	private String base;
	
	private String date;
	
	public Map<String, String> getRates() {
		return rates;
	}
	
	public void setRates(Map<String, String> rates) {
		this.rates = rates;
	}
	
	public String getBase() {
		return base;
	}
	
	public void setBase(String base) {
		this.base = base;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String calcNewAmount(String amount) {
		Entry<String, String> values = this.rates.entrySet().iterator().next();
		BigDecimal valueConversion = new BigDecimal(values.getValue());
		return new BigDecimal(amount).multiply(valueConversion).toString();
	}

	@Override
	public String toString() {
		return "CurrencyDTO [rates=" + rates + ", base=" + base + ", date=" + date + "]";
	}
}
