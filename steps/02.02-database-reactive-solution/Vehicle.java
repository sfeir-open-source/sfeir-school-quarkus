package com.sfeir.kart.pojo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "Vehicle")
@Cacheable
public class Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(unique = true, nullable = false)
    public String name;

    @NotNull
    @Column(precision = 2, nullable = false)
    public float speed;

    @NotNull
    @Column(precision = 2, nullable = false)
    public float acceleration;
}
