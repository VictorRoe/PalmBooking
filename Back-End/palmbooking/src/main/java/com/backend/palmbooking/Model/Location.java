package com.backend.palmbooking.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lenght")
    private Float length;
    @Column(name = "latitude")
    private Float latitude;

    public Location() {
    }

    public Location(Float length, Float latitude) {
        this.length = length;
        this.latitude = latitude;
    }

    @OneToMany(mappedBy = "location")
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
