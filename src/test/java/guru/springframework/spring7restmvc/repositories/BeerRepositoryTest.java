package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @BeforeEach
    void setUp() {
        Beer beer1 = Beer.builder()
                .beerName("Jever")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("123")
                .price(BigDecimal.valueOf(1.99))
                .quantityOnHand(99)
                .build();

        beerRepository.save(beer1);

        Beer beer2 = Beer.builder()
                .beerName("Köpi")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("456")
                .price(BigDecimal.valueOf(2.99))
                .quantityOnHand(1)
                .build();

        beerRepository.save(beer2);
    }

    @Test
    void testSaveBeer() {

        Beer savedBeer = beerRepository.save(Beer.builder().beerName("My Beer").build());
        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}