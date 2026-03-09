package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID beerId) {

        log.debug("Get Beer By ID in service was called.");

        return Beer.builder()
                .id(beerId)
                .version(1)
                .beerName("Chato")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("123")
                .price(BigDecimal.valueOf(1.99))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}