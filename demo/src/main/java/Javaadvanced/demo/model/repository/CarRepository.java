package Javaadvanced.demo.model.repository;

import Javaadvanced.demo.model.entity.Car;
import Javaadvanced.demo.model.enums.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByName(String name);

    List<Car> findAllByCarType(CarType carType);

    @Query("select car from Car car where car.carType = :carType")
    List<Car> getCars(@Param("carType") CarType carType);

    @Query(value = "select * from cars where cars.car_type = :carType", nativeQuery = true)
    List<Car> getCarsNative(@Param("carType") CarType carType);
}

