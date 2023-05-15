package com.backend.palmbooking.Service;

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

    public Optional<City> getCityByID(Long id) {
        return cityRepository.findById(id);
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public City editCity(City city) {
        Optional<City> editCity = cityRepository.findById(city.getId());

        if (editCity.isPresent()) {
            return cityRepository.save(city);
        } else {
            System.out.println("No se encontro el producto");
        }
        return city;
    }

    public void deleteCityByID(Long id) {
        Optional<City> city = cityRepository.findById(id);
        if (city.isPresent()) {
            cityRepository.deleteById(id);
        }
    }
}
