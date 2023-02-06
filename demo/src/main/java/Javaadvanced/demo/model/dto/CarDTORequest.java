package Javaadvanced.demo.model.dto;

import Javaadvanced.demo.model.enums.CarType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTORequest {
    CarType carType;
    String issueDate;
    Integer wheels;
    String name;

}
