package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.mappers.CustomerMapper;
import guru.springframework.spring7restmvc.model.CustomerDTO;
import guru.springframework.spring7restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJpa implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> listCustomer() {
        return List.of();
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customer) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customer) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customer) {

    }
}
