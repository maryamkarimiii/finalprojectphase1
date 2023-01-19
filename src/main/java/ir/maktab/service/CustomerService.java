package ir.maktab.service;

import ir.maktab.data.model.Customer;
import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;

import java.util.List;

public interface CustomerService extends BaseService<Customer> {
    Customer login(String username, String password);

    void changePassword(String newPassword, Customer customer);

    List<Customer> findAllCustomer();
    List<Service> seeServicesToChose();

    List<SubService> seeSubServicesToChose(Service service);
}
