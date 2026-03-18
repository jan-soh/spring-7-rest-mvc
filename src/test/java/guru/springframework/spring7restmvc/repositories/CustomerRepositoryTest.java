package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer1 = Customer.builder()
                .customerName("Harald Junke")
                .build();

        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .customerName("Janny Armstrong")
                .build();

        customerRepository.save(customer2);
    }

    @Test
    void testSaveBeer() {

        Customer savedCustomer = customerRepository.save(Customer.builder().customerName("My Customer").build());
        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isNotNull();
    }
}
