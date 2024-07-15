package com.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Page<Customer> findAll(Pageable pageable);
	
	Customer save(Customer customer);

	Customer findByCid(int cid);
	
	void deleteByCid(int cid);
	
	


}
