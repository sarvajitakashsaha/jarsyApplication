package com.example.springboot;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//@FeignClient(name = "currency-conversion-service")
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-conversion-service")
public interface CurrencyConversionServiceProxy {
	
	@GetMapping("currency-conversion-service/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
//	@HystrixCommand(fallbackMethod = "getFallBackValue")
	public UserCurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity);

}
