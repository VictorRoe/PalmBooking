package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.Location;
import com.backend.palmbooking.Repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getLocation() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationByID(Long id) {
        return locationRepository.findById(id);
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Location editLocation(Location location) {
        Optional<Location> editLocation = locationRepository.findById(location.getId());

        if (editLocation.isPresent()) {
            return locationRepository.save(location);
        } else {
            System.out.println("ID not found");
        }
        return location;
    }

    public void deleteLocationByID(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            locationRepository.deleteById(id);
        }
    }
}
