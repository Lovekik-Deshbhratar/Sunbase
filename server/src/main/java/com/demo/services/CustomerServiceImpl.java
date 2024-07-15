package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.dao.CustomerDao;
import com.demo.model.Customer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao cd;

	@Override
	public Customer addCustomer(Customer customer) {
		
		return cd.save(customer);
	}

	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return cd.findAll(pageable);
	}

	@Override
	public Customer findByCid(int cid) {
		return cd.findByCid(cid);
	}

	@Override
	public void deleteByCid(int cid) {
		cd.deleteById(cid);
	}
}
