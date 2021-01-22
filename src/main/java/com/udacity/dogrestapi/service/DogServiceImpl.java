package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveAllBreeds() {
        return dogRepository.findAllBreeds();
    }


    @Override
    public List<String> retrieveAllNames() {
        return dogRepository.findAllNames();
    }

    @Override
    public String retrieveBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
}
