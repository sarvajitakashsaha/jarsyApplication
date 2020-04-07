package com.example.springboot;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")

	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		System.out.println("RESPONSE  is >>>" + response);
		logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConvirsionMultiple(), quantity,
				quantity.multiply(response.getConvirsionMultiple()), 0);
	}

	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	@HystrixCommand(fallbackMethod = "getFallBackValue")
	public ResponseEntity<CurrencyConversionBean> convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean response = new CurrencyConversionBean();
		try {
			response = proxy.retriveExchangeValue(from, to);
		} catch (Exception e) {
			throw new DataNotFoundException("data not present");
		}
		System.out.println("RESPONSE  is >>>" + response);
		logger.info("{}", response);
		CurrencyConversionBean requiredResponse = new CurrencyConversionBean(response.getId(), from, to, response.getConvirsionMultiple(), quantity,
				quantity.multiply(response.getConvirsionMultiple()), response.getPort());

		return new ResponseEntity<CurrencyConversionBean>(requiredResponse, HttpStatus.OK);
				}

//This Method will be called when CurrencyExchange Service is down
	public ResponseEntity<CurrencyConversionBean> getFallBackValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean fallBackObj = new CurrencyConversionBean();
		fallBackObj.setFrom(from);
		return new ResponseEntity<CurrencyConversionBean>(fallBackObj, HttpStatus.GATEWAY_TIMEOUT);
	}
}