package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> listCustomer();

    Customer getCustomerById(UUID customerId);

    Customer saveCustomer(Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, Customer customer);
}
