package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> listCustomer();

    Optional<CustomerDTO> getCustomerById(UUID customerId);

    CustomerDTO saveCustomer(CustomerDTO customer);

    void updateCustomerById(UUID customerId, CustomerDTO customer);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customer);
}
