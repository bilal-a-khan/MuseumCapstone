package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("Painting")
public class Painting extends Art {

    @Enumerated(value = EnumType.STRING)
    private Style style;

}
