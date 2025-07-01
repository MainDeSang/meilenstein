package com.example.meilenstein.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private Date dateOfBirth;
}
