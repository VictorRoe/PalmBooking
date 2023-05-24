package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.City;
import com.backend.palmbooking.Model.Location;
import com.backend.palmbooking.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCity() {
        return cityService.getCity();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityByID(@PathVariable Long id) throws GlobalExcepction {
        City city = cityService.getCityByID(id);
        if (city == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
    }

    @PostMapping
    public void addCity(@RequestBody City city) {
        cityService.addCity(city);
    }

    @PutMapping
    public ResponseEntity<City> editCity(@RequestBody City city) throws GlobalExcepction {
        City searchCity = cityService.getCityByID(city.getId());
        if (searchCity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.editCity(city));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCityByID(@PathVariable Long id) throws GlobalExcepction {
        City searchCity = cityService.getCityByID(id);
        if (searchCity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        cityService.deleteCityByID(id);
        return ResponseEntity.noContent().build();
    }
}
