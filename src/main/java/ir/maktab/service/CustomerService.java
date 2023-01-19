package ir.maktab.service;

import ir.maktab.data.model.Customer;

public interface CustomerService extends BaseService<Customer> {
    Customer login(String username, String password);

    void changePassword(String newPassword, Customer customer);
}
