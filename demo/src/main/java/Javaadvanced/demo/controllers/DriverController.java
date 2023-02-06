package Javaadvanced.demo.controllers;

import Javaadvanced.demo.model.dto.DriverDTORequest;
import Javaadvanced.demo.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    public DriverDTORequest createDriver(@RequestBody DriverDTORequest driverDTORequest) {

        return driverService.createDriver(driverDTORequest);
    }

    @PutMapping
    public ResponseEntity<DriverDTORequest> updateDriver(@RequestBody DriverDTORequest driverDTORequest) {

        return ResponseEntity.ok(driverService.update(driverDTORequest));
    }

    @GetMapping
    public ResponseEntity<DriverDTORequest> getDriver(@RequestParam String email) {

        return ResponseEntity.ok(driverService.get(email));
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteDriver(@RequestParam String email) {

        driverService.delete(email);
        return ResponseEntity.ok().build();
    }

}
