package Javaadvanced.demo.model.entity;

import Javaadvanced.demo.model.enums.DriverStatus;
import Javaadvanced.demo.model.enums.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Drivers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer age;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(unique = true)
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
    List<Car> cars;

    @Enumerated(EnumType.STRING)
    DriverStatus status;

}
