package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.entity.Dog;
import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveAllBreeds();
    String retrieveBreedById(Long id);
    List<String> retrieveAllNames();
}
