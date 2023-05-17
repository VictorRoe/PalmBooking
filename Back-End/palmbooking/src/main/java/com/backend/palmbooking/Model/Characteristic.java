package com.backend.palmbooking.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "characteristics")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "characteristic", length = 50)
    private String characteristic;

    public Characteristic() {
    }

    public Characteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
