package ir.maktab.service.impl;

import ir.maktab.dao.CustomerRepository;
import ir.maktab.data.enums.Role;
import ir.maktab.data.model.Customer;
import ir.maktab.data.model.Wallet;
import ir.maktab.exception.NotCorrectInputException;
import ir.maktab.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private static CustomerService customerService;
    private final CustomerRepository customerRepository = CustomerRepository.getInstance();

    private CustomerServiceImpl() {
    }

    public static CustomerService getInstance() {
        if (customerService == null)
            return new CustomerServiceImpl();
        return customerService;
    }

    @Override
    public void save(Customer customer) {
        customer.setUsername(customer.getEmail());
        customer.setRole(Role.CUSTOMER);
        customer.setWallet(new Wallet(0.0));
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }


    public Customer login(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if (!customer.getPassword().equals(password))
            throw new NotCorrectInputException("the password is not correct");
        return customer;
    }

    public void changePassword(String newPassword, Customer customer) {
        customer.setPassword(newPassword);
        customerRepository.update(customer);
    }
}
