package Javaadvanced.demo.model.dto;

import Javaadvanced.demo.model.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverDTORequest {

    Integer age;
    String firstName;
    String lastName;
    Gender gender;
    String email;

}

