package com.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Museum {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Curator curator;

    @OneToMany(mappedBy = "museum")
    @JsonManagedReference
    private List<Art> artList;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

}
