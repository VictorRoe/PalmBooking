package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalException;
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

    public Location getLocationByID(Long id) throws GlobalException {
        Optional<Location> searchLocation = locationRepository.findById(id);
        if (searchLocation.isPresent()){
            return searchLocation.get();
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public Location editLocation(Location location) throws GlobalException {
        Optional<Location> editLocation = locationRepository.findById(location.getId());
        if (editLocation.isPresent()) {
            return locationRepository.save(location);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }

    }

    public void deleteLocationByID(Long id) throws GlobalException {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            locationRepository.deleteById(id);
        } else {
            throw new GlobalException("ID NOT FOUND");
        }
    }
}
