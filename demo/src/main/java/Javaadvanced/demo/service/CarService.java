package Javaadvanced.demo.service;

import Javaadvanced.demo.model.dto.CarDTORequest;
import Javaadvanced.demo.model.dto.CarDTOResponse;

public interface CarService {
    CarDTORequest create(CarDTORequest carDTORequest);
    CarDTORequest update(CarDTORequest carDTORequest);

    CarDTORequest get(String name);

    void delete(String name);

    CarDTOResponse addToDriver(String name, String email);
}
