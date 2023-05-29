package com.backend.palmbooking.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "policies")
public class Politics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "politics")
    private String politics;

    @OneToMany(mappedBy = "politics")
    private List<Product> products;

    public Politics() {
    }

    public Politics(String politics) {
        this.politics = politics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }
}
