package com.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.model.Customer;

public interface CustomerService {


	Page<Customer> findAll(Pageable pageable);
	
	Customer addCustomer(Customer customer);
	
	Customer findByCid(int cid);

	void deleteByCid(int cid);

}
