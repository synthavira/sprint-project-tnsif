package com.tnsif.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tnsif.shoppingmall.entity.Customer;
import com.tnsif.shoppingmall.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerRepo.findById(id).get();
	}

	@GetMapping
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody Customer Customer) {
		return customerRepo.save(Customer);
	}

	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {

		customer.setId(id);
		customerRepo.save(customer);

	}

	@DeleteMapping("/{id}")
	public void deleteCustomerById(@PathVariable Long id) {
		customerRepo.deleteById(id);
	}
}
