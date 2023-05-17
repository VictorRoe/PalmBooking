package com.backend.palmbooking.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name", length = 50)
    private String city;

    @OneToMany(mappedBy = "city")
    private List<Product>product;

    public City() {
    }

    public City(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
