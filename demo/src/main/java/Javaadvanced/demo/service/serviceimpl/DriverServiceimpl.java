package Javaadvanced.demo.service.serviceimpl;

import Javaadvanced.demo.exceptions.CustomException;
import Javaadvanced.demo.model.dto.DriverDTORequest;
import Javaadvanced.demo.model.entity.Driver;
import Javaadvanced.demo.model.enums.DriverStatus;
import Javaadvanced.demo.model.repository.DriverRepository;
import Javaadvanced.demo.service.DriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class DriverServiceimpl implements DriverService {

    private final DriverRepository driverRepository;
    private final ObjectMapper mapper;

    @Override
    public DriverDTORequest createDriver(DriverDTORequest driverDTORequest) {
        driverRepository.findByEmail(driverDTORequest.getEmail()).ifPresent(
                car -> {
                    throw new CustomException("Водитель с таким email уже существет", HttpStatus.BAD_REQUEST);
                }
        );

        Driver driver = mapper.convertValue(driverDTORequest, Driver.class);
        Driver save = driverRepository.save(driver);

        return mapper.convertValue(save, DriverDTORequest.class);
    }

    @Override
    public DriverDTORequest update(DriverDTORequest driverDTORequest) {
        Driver driver = getDriver(driverDTORequest.getEmail());

        driver.setAge(driverDTORequest.getAge() == null ? driver.getAge(): driverDTORequest.getAge());
        driver.setFirstName(driverDTORequest.getFirstName() == null ? driver.getFirstName(): driverDTORequest.getFirstName());
        driver.setLastName(driverDTORequest.getLastName() == null ? driver.getLastName(): driverDTORequest.getLastName());
        driver.setGender(driverDTORequest.getGender() == null ? driver.getGender(): driverDTORequest.getGender());
        driver.setUpdatedAt(LocalDateTime.now());
        driver.setStatus(DriverStatus.UPDATED);

        return mapper.convertValue(driverRepository.save(driver), DriverDTORequest.class);
    }

    @Override
    public DriverDTORequest get(String email) {
        return mapper.convertValue(getDriver(email), DriverDTORequest.class);
    }

    @Override
    public void delete(String email) {
        Driver driver = getDriver(email);
        driver.setStatus(DriverStatus.DELETED);
        driver.setUpdatedAt(LocalDateTime.now());
        driverRepository.save(driver);
    }

    @Override
    public Driver getDriver(String email) {
        return driverRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("Водитель с таким email не найден", HttpStatus.NOT_FOUND));
    }   }
 /*   @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {

        *//*Driver driver = new Driver();*//*
*//*        driver.setAge(driverDTO.getAge());
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setGender(driverDTO.getGender());*//*

        *//*Driver driver = mapper.convertValue(driverDTO, Driver.class);

        driver.setCreatedAt(LocalDateTime.now());

        List<Car> cars = driverDTO.getCars().stream()
                .map(c -> {
                    Car car = new Car();
                    car.setCarType(c.getCarType());
                    car.setWheels(c.getWheels());
                    try {
                        car.setIssueDate(LocalDate.parse(c.getIssueDate()));
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        throw new RuntimeException(e);
                    }
                    return car;
                })
                .collect(Collectors.toList());

        driver.setCars(cars);

        Driver entity = driverRepository.save(driver);

        DriverDTO result = mapper.convertValue(entity, DriverDTO.class);
        List<CarDTO> carsDTO = entity.getCars().stream()
                .map(c -> {

                    CarDTO carDTO = new CarDTO();
                    carDTO.setCarType(c.getCarType());
                    carDTO.setWheels(c.getWheels());
                    carDTO.setIssueDate(String.valueOf(c.getIssueDate()));
                    return carDTO;
                })
                .collect(Collectors.toList());

        result.setCars(carsDTO);*//*

        return null;*/
/*
}
        }
*/


