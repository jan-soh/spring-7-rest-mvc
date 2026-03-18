package guru.springframework.spring7restmvc.bootstrap;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.entities.Customer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import guru.springframework.spring7restmvc.repositories.BeerRepository;
import guru.springframework.spring7restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    public void run(String... args) {
        loadBeerData();
        loadCustomerData();
    }

    private void loadCustomerData() {

        if (0 == customerRepository.count()) {

            Customer customer1 = Customer.builder()
                    .customerName("Hoje")
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("John")
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .customerName("Derek")
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }
    }

    private void loadBeerData() {

        if (0 == beerRepository.count()) {
            Beer beer1 = Beer.builder()
                    .beerName("Chato")
                    .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                    .upc("123")
                    .price(BigDecimal.valueOf(1.99))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Gato")
                    .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                    .upc("456")
                    .price(BigDecimal.valueOf(3.99))
                    .quantityOnHand(999)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Salvador")
                    .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                    .upc("789")
                    .price(BigDecimal.valueOf(0.99))
                    .quantityOnHand(1)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.saveAll(Arrays.asList(beer1, beer2, beer3));
        }
    }
}
