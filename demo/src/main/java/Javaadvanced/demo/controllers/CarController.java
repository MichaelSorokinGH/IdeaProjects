package Javaadvanced.demo.controllers;

import Javaadvanced.demo.model.dto.CarDTORequest;
import Javaadvanced.demo.model.dto.CarDTOResponse;
import Javaadvanced.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarDTORequest> createCar(@RequestBody CarDTORequest carDTORequest) {

        return ResponseEntity.ok(carService.create(carDTORequest));
    }

    @PutMapping
    public ResponseEntity<CarDTORequest> updateCar(@RequestBody CarDTORequest carDTORequest) {

        return ResponseEntity.ok(carService.update(carDTORequest));
    }

    @GetMapping
    public ResponseEntity<CarDTORequest> getCar(@RequestParam String name) {

        return ResponseEntity.ok(carService.get(name));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteCar(@RequestParam String name) {

        carService.delete(name);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/carOwner")
    public ResponseEntity<CarDTOResponse> addToDriver(@RequestParam String name, @RequestParam String email) {
        return ResponseEntity.ok(carService.addToDriver(name, email));
    }

}
