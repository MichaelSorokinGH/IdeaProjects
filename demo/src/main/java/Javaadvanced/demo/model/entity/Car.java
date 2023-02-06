package Javaadvanced.demo.model.entity;

import Javaadvanced.demo.model.enums.CarStatus;
import Javaadvanced.demo.model.enums.CarType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "cars")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "car_type")
    CarType carType;

    @Column(name = "issue_date")
    String issueDate;

    @Column(name = "wheels")
    Integer wheels;

    @CreationTimestamp
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    Driver driver;

    String name;

    @Enumerated(EnumType.STRING)
    CarStatus status = CarStatus.CREATED;
}
