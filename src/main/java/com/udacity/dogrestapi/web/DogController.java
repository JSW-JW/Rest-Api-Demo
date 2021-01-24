package com.udacity.dogrestapi.web;

import com.udacity.dogrestapi.entity.Dog;
import com.udacity.dogrestapi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Dog microservice is running.")
})
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
