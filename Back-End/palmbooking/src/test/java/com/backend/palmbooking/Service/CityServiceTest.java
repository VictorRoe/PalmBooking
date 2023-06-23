package com.backend.palmbooking.Service;

import com.backend.palmbooking.Model.City;
import com.backend.palmbooking.Repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceTest {

    private CityService cityService;
    @Mock
    private CityRepository cityRepository;

    @BeforeEach
    public void setCity() {
        MockitoAnnotations.openMocks(this);
        cityService = new CityService(cityRepository);

        City city = new City(1L, "Medellin", null);
        City city2 = new City(2L, "Bogota", null);

    }

    @DisplayName("Test for list cities")
    @Test
    void getCity() {
        List<City> cities = cityService.getCity();
        assertNotNull(cities);
    }

    @DisplayName("Test for get city by ID")
    @Test
    void getCityByID() {
        Long id = 1L;
        City city = new City(1L, "Medellin", null);
        Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(city));
        City cityGetID = cityService.getCityByID(id);
        assertEquals(city, cityGetID);
        assertNotNull(cityGetID);
    }

    @Test
    @DisplayName("Test for add a city")
    void addCity() {
        City city = new City(1L, "Cali", null);
        cityService.addCity(city);
        assertNotNull(city);
    }

        @Test
        @DisplayName("Test for can edit one city")
        void editCity() {
            Long id = 3L;
            City city = new City(id, "Cucuta", null);
            Mockito.when(cityRepository.findById(id)).thenReturn(Optional.of(city));
            Mockito.when(cityRepository.save(city)).thenReturn(city);
            City editedCity = cityService.editCity(city);

            assertNotNull(editedCity);
            assertEquals("Cucuta", editedCity.getCity());

        }

    @Test
    @DisplayName("Test for can delete one city")
    void deleteCityByID() {
        Long cityId = 1L;
        Mockito.when(cityRepository.findById(cityId)).thenReturn(Optional.of(new City()));

        CityService cityService = new CityService(cityRepository);
        cityService.deleteCityByID(cityId);

        Mockito.verify(cityRepository).deleteById(cityId);

    }
}