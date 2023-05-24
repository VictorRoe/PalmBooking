package com.backend.palmbooking.Controller;


import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.Location;
import com.backend.palmbooking.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocation() {
        return locationService.getLocation();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationByID(@PathVariable Long id) throws GlobalExcepction {
        Location location = locationService.getLocationByID(id);
        if (location == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(location);
        }
    }

    @PostMapping
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping
    public ResponseEntity<Location> editLocation(@RequestBody Location location) throws GlobalExcepction {
        Location searchLocation = locationService.getLocationByID(location.getId());
        if (searchLocation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(locationService.editLocation(location));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationByID(@PathVariable Long id) throws GlobalExcepction {
        Location searchLocation = locationService.getLocationByID(id);
        if (searchLocation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        locationService.deleteLocationByID(id);
        return ResponseEntity.noContent().build();
    }
}
