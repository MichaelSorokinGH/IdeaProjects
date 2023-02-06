package Javaadvanced.demo.service;

import Javaadvanced.demo.model.dto.DriverDTORequest;
import Javaadvanced.demo.model.entity.Driver;

public interface DriverService {

    DriverDTORequest createDriver(DriverDTORequest driverDTORequest);

    DriverDTORequest update(DriverDTORequest driverDTORequest);

    DriverDTORequest get(String email);

    void delete(String email);

    Driver getDriver(String email);
}
