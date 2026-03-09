package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.model.Beer;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID beerId);
}
