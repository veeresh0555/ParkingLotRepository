package com.parkvehicle.client;

import java.util.List;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.parkvehicle.exception.AlreadyExistException;
import com.parkvehicle.request.Customer;
import com.parkvehicle.request.TransactionHistory;


@FeignClient(name = "http://bankservice/bankservice")
public interface BankServiceClient {

	@GetMapping("/info")
	public String info();
	
	@PostMapping
	public  ResponseEntity<Customer> createUser(@Valid @RequestBody Customer cust) throws AlreadyExistException;
		
	@PostMapping("/payment") //@RequestParam("amount")
	public ResponseEntity<TransactionHistory> payment(@RequestParam("cid") long cid,@RequestParam("amount") Double amount) throws Exception;
	
	@GetMapping("/lateststmt")
	public ResponseEntity<List<TransactionHistory>> latest10records(@RequestParam("userid") long userid);
	
}
