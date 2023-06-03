package com.backend.palmbooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "image", length = 200)
    private String image;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Room> rooms;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "policy_id", referencedColumnName = "id")
    private Politics politics;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "product_characteristic",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_id")
    )
    private Set<Characteristic> characteristic = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "product")
    private Booking booking;
}
