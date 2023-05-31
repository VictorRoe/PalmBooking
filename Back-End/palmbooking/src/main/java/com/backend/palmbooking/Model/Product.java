package com.backend.palmbooking.Model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "product")
    private List<Room> rooms;

    @OneToMany(mappedBy = "product")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "policy_id", referencedColumnName = "id")
    private Politics politics;

    @ManyToMany
    @JoinTable(name = "product_characteristic",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "characteristic_id")
    )
    private Set<Characteristic> characteristic = new HashSet<>();


    public Product() {
    }

    public Product(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
