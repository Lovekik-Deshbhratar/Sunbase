package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Customer;
import com.demo.services.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@GetMapping(value = "{id}")
	public Customer findOne(@PathVariable int id) {
		return cs.findByCid(id);
	}


	@GetMapping
	public ResponseEntity<List<Customer>> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "cid") String sortBy) {
		Pageable paging = PageRequest.of(page, pageSize, Sort.by(sortBy));
		Page<Customer> pagedResult = cs.findAll(paging);
		List<Customer> products = pagedResult.getContent();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<List<Customer>> saveCustomer(@RequestBody List<Customer> categories) {
		if(categories.size()==0)
			 return new ResponseEntity<List<Customer>>( HttpStatus.NO_CONTENT);
			
		List<Customer> list = new ArrayList<Customer>();
		for (Customer Customer : categories) {
			list.add(cs.addCustomer(Customer));
		}
		return new ResponseEntity<List<Customer>>(list, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Customer> deleteProduct(@PathVariable int id) {
		Customer existingCustomer = cs.findByCid(id);

		if (existingCustomer != null) {
			cs.deleteByCid(id);
			return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
		} else
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);

	}
}
