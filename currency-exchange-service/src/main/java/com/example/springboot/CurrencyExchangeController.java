package com.example.springboot;

import java.math.BigDecimal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyExchangeController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//@HystrixCommand(fallbackMethod = "getFallBackValue")
	public ResponseEntity<ExchangeValue>retriveExchangeValue( @PathVariable String from, @PathVariable String to) {
		// ExchangeValue exchangeValue = new ExchangeValue(1000L, from,
		// to,BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = new ExchangeValue();
		// try {
		exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		// } catch (Exception e) {
		// throw new DataNotFoundException("no data found");
		// }

		logger.info("{EXCHANGE VAL IS >>>>>>>>>}", exchangeValue);
		return  new ResponseEntity<ExchangeValue>(exchangeValue,HttpStatus.FOUND);

	}

//	public ExchangeValue getFallBackValue(@PathVariable String from, @PathVariable String to) {
//		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
//		return exchangeValue;
//	}
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	public Optional<ExchangeValue> retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		Optional<ExchangeValue> exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
//		if(exchangeValue.isPresent()){
//			logger.info("{EXCHANGE VAL IS >>>>>>>>>}",exchangeValue);
//			return exchangeValue;
//		} else {
//			throw new DataNotFoundException("thers is no data present");
//		}		
//	}

}
