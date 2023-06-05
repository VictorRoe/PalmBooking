package com.backend.palmbooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table (name = "policies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Politics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "politics")
    private String politics;

    @JsonIgnore
    @OneToMany(mappedBy = "politics")
    private List<Product> products;

}

