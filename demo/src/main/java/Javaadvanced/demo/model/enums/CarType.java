package Javaadvanced.demo.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum CarType {

    TOYOTA("TOYOTA"),
    NISSAN("NISSAN"),
    KIA("KIA"),
    FORD("FORD"),
    VOLKSWAGEN("VOLKSWAGEN");

    private final String description;
}
