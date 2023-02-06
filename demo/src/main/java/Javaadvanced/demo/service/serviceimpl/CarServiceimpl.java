package Javaadvanced.demo.service.serviceimpl;

import Javaadvanced.demo.exceptions.CustomException;
import Javaadvanced.demo.model.dto.CarDTORequest;
import Javaadvanced.demo.model.dto.CarDTOResponse;
import Javaadvanced.demo.model.dto.DriverDTORequest;
import Javaadvanced.demo.model.entity.Car;
import Javaadvanced.demo.model.entity.Driver;
import Javaadvanced.demo.model.enums.CarStatus;
import Javaadvanced.demo.model.repository.CarRepository;
import Javaadvanced.demo.model.repository.DriverRepository;
import Javaadvanced.demo.service.CarService;
import Javaadvanced.demo.service.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceimpl implements CarService {
    private final DriverRepository driverRepository;

    private final DriverService driverService;

    private final CarRepository carRepository;
    private final ObjectMapper mapper;

    @Override
    public CarDTORequest create(CarDTORequest carDTORequest) {
        carRepository.findByName(carDTORequest.getName()).ifPresent(
                car -> {
                    throw new CustomException("Автомобиль с таким названием уже существет", HttpStatus.BAD_REQUEST);
                }
        );

        Car car = mapper.convertValue(carDTORequest, Car.class);
        Car save = carRepository.save(car);

        return mapper.convertValue(save, CarDTORequest.class);
    }

    @Override
    public CarDTORequest update(CarDTORequest carDTORequest) {
        Car car = getCar(carDTORequest.getName());

        car.setCarType(carDTORequest.getCarType() == null ? car.getCarType() : carDTORequest.getCarType());
        car.setWheels(carDTORequest.getWheels() == null ? car.getWheels() : carDTORequest.getWheels());
        car.setIssueDate(StringUtils.isBlank(carDTORequest.getIssueDate()) ? car.getIssueDate() : carDTORequest.getIssueDate());
        car.setUpdatedAt(LocalDateTime.now());
        car.setStatus(CarStatus.UPDATED);

        return mapper.convertValue(carRepository.save(car), CarDTORequest.class);
    }

    @Override
    public CarDTORequest get(String name) {
        return mapper.convertValue(getCar(name), CarDTORequest.class);
    }

    @Override
    public void delete(String name) {
        Car car = getCar(name);
        car.setStatus(CarStatus.DELETED);
        car.setUpdatedAt(LocalDateTime.now());
        carRepository.save(car);
    }


    private Car getCar(String carDTO) {
        return carRepository.findByName(carDTO)
                .orElseThrow(() -> new CustomException("Автомобиль с таким названием не найден", HttpStatus.NOT_FOUND));
    }

    @Override
    public CarDTOResponse addToDriver(String name, String email) {
        Driver driver = driverService.getDriver(email);
        Car car = getCar(name);
        car.setDriver(driver);
        Car save = carRepository.save(car);
        CarDTOResponse carDTOResponse = mapper.convertValue(save, CarDTOResponse.class);
        carDTOResponse.setDriverDTORequest(mapper.convertValue(driver, DriverDTORequest.class));
        return carDTOResponse;
    }



}


