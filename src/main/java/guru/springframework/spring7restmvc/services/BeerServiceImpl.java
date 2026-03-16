package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.BeerDTO;
import guru.springframework.spring7restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
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

        BeerDTO beer2 = BeerDTO.builder()
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

        BeerDTO beer3 = BeerDTO.builder()
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
    public List<BeerDTO> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID beerId) {

        log.debug("Get Beer By ID in service was called.");

        return Optional.of(beerMap.get(beerId));
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beer) {

        BeerDTO savedBeer = BeerDTO.builder().id(UUID.randomUUID())
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

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {

        BeerDTO existingBeer = beerMap.get(beerId);

        existingBeer.setBeerName(beer.getBeerName());
        existingBeer.setBeerStyle(beer.getBeerStyle());
        existingBeer.setPrice(beer.getPrice());
        existingBeer.setUpc(beer.getUpc());
        existingBeer.setUpdateDate(LocalDateTime.now());
        existingBeer.setQuantityOnHand(beer.getQuantityOnHand());

        beerMap.put(beerId, existingBeer);
    }

    @Override
    public void deleteById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {
        BeerDTO existing = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())){
            existing.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null){
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existing.setUpc(beer.getUpc());
        }
    }
}