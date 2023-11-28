package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String country;

    @OneToOne(mappedBy = "location")
    @JsonBackReference
    private Museum museum;

}
