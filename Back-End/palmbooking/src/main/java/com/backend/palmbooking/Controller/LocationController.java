package com.backend.palmbooking.Controller;


import com.backend.palmbooking.Model.Location;
import com.backend.palmbooking.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Location> getLocationByID(@PathVariable Long id) {
        return locationService.getLocationByID(id);
    }

    @PostMapping
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping
    public ResponseEntity<Void> editLocation(@RequestBody Location location) {
        Optional<Location> searchLocation = locationService.getLocationByID(location.getId());

        if (searchLocation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        locationService.editLocation(location);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationByID(@PathVariable Long id) {
        Optional<Location> searchLocation = locationService.getLocationByID(id);

        if (searchLocation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        locationService.deleteLocationByID(id);
        return ResponseEntity.status(204).build();
    }
}
