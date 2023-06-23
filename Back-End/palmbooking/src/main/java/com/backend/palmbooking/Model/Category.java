package com.backend.palmbooking.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
