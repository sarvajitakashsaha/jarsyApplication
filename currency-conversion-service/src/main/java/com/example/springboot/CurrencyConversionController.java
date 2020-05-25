package com.example.springboot;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

//using RestTemplate getForEntity() 
	@GetMapping("/currency-exchange/from/{fr}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable("fr") String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);
		System.out.println(" ResponseEntity status code is for getForEntity >>>" + responseEntity.getHeaders());
		CurrencyConversionBean response = responseEntity.getBody();
		System.out.println("RESPONSE  is >>>" + response);
		logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConvirsionMultiple(), quantity,
				quantity.multiply(response.getConvirsionMultiple()), 0);
	}

	// using RestTemplate exchange()
	@GetMapping("/currency-exchange1/from/{fr}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency1(@PathVariable("fr") String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().exchange(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", HttpMethod.GET, entity,
				CurrencyConversionBean.class, uriVariables);
		logger.debug(" ResponseEntity status code is for exchange {}", responseEntity.getHeaders());
		CurrencyConversionBean response = responseEntity.getBody();
		System.out.println("RESPONSE  is >>>" + response);
		logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConvirsionMultiple(), quantity,
				quantity.multiply(response.getConvirsionMultiple()), 0);
	}

	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
//	@HystrixCommand(fallbackMethod = "getFallBackValue")
	public ResponseEntity<CurrencyConversionBean> convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		CurrencyConversionBean response = new CurrencyConversionBean();
		try {
			response = proxy.retriveExchangeValue(from, to);
		} catch (Exception e) {
			throw new DataNotFoundException("data not present");
		}
		// Object session = request;
		// System.out.println("RESPONSE is >>>" + request.getSession());
		logger.info("{}", response);
		CurrencyConversionBean requiredResponse = new CurrencyConversionBean(response.getId(), from, to,
				response.getConvirsionMultiple(), quantity, quantity.multiply(response.getConvirsionMultiple()),
				response.getPort());

		return new ResponseEntity<CurrencyConversionBean>(requiredResponse, HttpStatus.OK);
	}

//This Method will be called when CurrencyExchange Service is down
//	public ResponseEntity<CurrencyConversionBean> getFallBackValue(@PathVariable String from, @PathVariable String to,
//			@PathVariable BigDecimal quantity, final HttpServletRequest request) {
//		CurrencyConversionBean fallBackObj = new CurrencyConversionBean();
//		fallBackObj.setFrom(from);
//		return new ResponseEntity<CurrencyConversionBean>(fallBackObj, HttpStatus.GATEWAY_TIMEOUT);
//	}
}
