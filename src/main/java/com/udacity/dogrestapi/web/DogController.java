package com.udacity.dogrestapi.web;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> retrieveBreeds() {
        List<String> breeds = dogService.retrieveAllBreeds();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> retrieveNames() {
        List<String> names = dogService.retrieveAllNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> retrieveBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }
}
