package com.backend.palmbooking.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "description", length = 250)
    private String description;
    @Column(name = "image")
    private String image;

    public Category() {
    }

    public Category(String title, String description, String image) {
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

    public String getTitulo() {
        return title;
    }

    public void setTitulo(String titulo) {
        this.title = titulo;
    }

    public String getDescripcion() {
        return description;
    }

    public void setDescripcion(String descripcion) {
        this.description = descripcion;
    }

    public String getImagen() {
        return image;
    }

    public void setImagen(String imagen) {
        this.image = imagen;
    }
}
