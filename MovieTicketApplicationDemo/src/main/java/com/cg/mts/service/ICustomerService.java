package com.cg.mts.service;

import java.util.List;

import com.cg.mts.entities.Customer;
import com.cg.mts.exception.CustomerNotFoundException;

public interface ICustomerService {
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException;
	public Customer viewCustomer(int custid) throws CustomerNotFoundException;
	public List<Customer> viewAllCustomers(int movieid);
	public List<Customer> viewCustomerList(int showid);

	public void deleteCustomer(int custid) throws CustomerNotFoundException;
	//public List<Customer> viewCustomerList(int theatreid);
	List<Customer> viewAllCustomersByMovieId(int movieid) throws CustomerNotFoundException;
	List<Customer> showAll() throws CustomerNotFoundException;

}
