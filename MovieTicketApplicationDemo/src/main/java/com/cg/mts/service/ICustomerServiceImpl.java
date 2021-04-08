package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.mts.entities.Booking;
import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.repository.ICustomerRepository;

@Service
@Transactional
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository repository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		if (repository.existsById(customer.getCustomerId())) {

			throw new CustomerNotFoundException("User Already Exists");
		}

		Customer customerObj = repository.save(customer);
		return customerObj;

	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		return repository.save(customer);
	}

	@Override
	public void deleteCustomer(int customerId) throws CustomerNotFoundException {

		if (repository.existsById(customerId)) {
			repository.deleteById(customerId);
		} 
		else {
			throw new CustomerNotFoundException("Invalid Id, cannot delete customer");
		}
	}

	@Override
	public Customer viewCustomer(int userId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> optCustomer = repository.findById(userId);
		if (!optCustomer.isPresent()) {
			throw new CustomerNotFoundException("No Customer present with the given id " + userId);
		} else
			return optCustomer.get();
	}

	@Override
	public List<Customer> viewAllCustomersByMovieId(int movieid) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> optCustomerList = repository.findById(movieid);
		if (optCustomerList.isPresent()) {
			throw new CustomerNotFoundException("No MovieId present");
		}
		return (List<Customer>) optCustomerList.get();
	}

	@Override
	public List<Customer> showAll() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customerList = repository.findAll();
		if (customerList.isEmpty()) {
			throw new CustomerNotFoundException("No Customers found");
		} else
			return customerList;
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomers(int movieid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewCustomerList(int showid) {
		// TODO Auto-generated method stub
		return null;
	}

}
