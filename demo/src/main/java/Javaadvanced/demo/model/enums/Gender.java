package Javaadvanced.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum Gender {

    MALE("Man"),
    FEMALE("Woman");

    private final String description;

}
