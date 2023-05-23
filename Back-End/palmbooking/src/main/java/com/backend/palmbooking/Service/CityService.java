package com.backend.palmbooking.Service;

import com.backend.palmbooking.Exception.GlobalExcepction;
import com.backend.palmbooking.Model.City;
import com.backend.palmbooking.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCity() {
        return cityRepository.findAll();
    }

    public City getCityByID(Long id) throws GlobalExcepction {
        Optional<City> searchCity = cityRepository.findById(id);
        if (searchCity.isPresent()){
            return searchCity.get();
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public City editCity(City city) throws GlobalExcepction {
        Optional<City> editCity = cityRepository.findById(city.getId());
        if (editCity.isPresent()) {
            return cityRepository.save(city);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }

    }

    public void deleteCityByID(Long id) throws GlobalExcepction {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            cityRepository.deleteById(id);
        } else {
            throw new GlobalExcepction("ID NOT FOUND");
        }
    }
}
