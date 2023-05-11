package com.backend.palmbooking.Controller;

import com.backend.palmbooking.Model.City;
import com.backend.palmbooking.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/City")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCity() {
        return cityService.getCity();
    }

    @GetMapping("/{id}")
    public Optional<City> getCityByID(@PathVariable Long id){
        return cityService.getCityByID(id);
    }

    @PostMapping
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }

    @PutMapping
    public ResponseEntity<Void> editCity(@RequestBody City city) {
        Optional<City> searchCity = cityService.getCityByID(city.getId());

        if (searchCity.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        cityService.editCity(city);
        return ResponseEntity.status(202).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCityByID(@PathVariable Long id) {
        Optional<City> searchCity = cityService.getCityByID(id);

        if (searchCity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cityService.deleteCityByID(id);
        return ResponseEntity.status(204).build();
    }
}
