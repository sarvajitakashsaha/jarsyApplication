package com.example.springboot;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserRepository userReporitory;
	@Autowired
	CurrencyConversionServiceProxy proxy;
	@GetMapping("/users")
	public List<User> getAllUsers(){
		List<User> users = userReporitory.findAll();
		return users;
	}
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		userReporitory.save(user);
		return user;
	}
	//@Transactional
	@GetMapping("user/{id}/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public UserCurrencyConversionBean getStatus(@PathVariable int id, @PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		List<User> user =userReporitory.findAllById(id);
		UserCurrencyConversionBean userCurrencyStatus= new UserCurrencyConversionBean();
		UserCurrencyConversionBean obj = 	proxy.convertCurrencyFeign(from, to, quantity);
		if(obj.getTotalCalculatedAmount().intValue()>5500) {
			userCurrencyStatus.setUserStatus("high");
			userCurrencyStatus.setName(user.get(0).getName());
			userCurrencyStatus.setTotalCalculatedAmount(obj.getTotalCalculatedAmount());
		}
		return userCurrencyStatus;
		
	}
	
	
}
