package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;
import guru.springframework.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Chato")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("123")
                .price(BigDecimal.valueOf(1.99))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(2)
                .beerName("Gato")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("456")
                .price(BigDecimal.valueOf(3.99))
                .quantityOnHand(999)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Salvador")
                .beerStyle(BeerStyle.NORD_DEUTSCHES_PILS_JUNGE)
                .upc("789")
                .price(BigDecimal.valueOf(0.99))
                .quantityOnHand(1)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        this.beerMap.put(beer1.getId(), beer1);
        this.beerMap.put(beer2.getId(), beer2);
        this.beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID beerId) {

        log.debug("Get Beer By ID in service was called.");

        return beerMap.get(beerId);
    }

    @Override
    public Beer saveBeer(Beer beer) {

        Beer savedBeer = Beer.builder().id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .version(beer.getVersion())
                .build();
        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }
}