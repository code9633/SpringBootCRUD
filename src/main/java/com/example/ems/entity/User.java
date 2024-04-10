package com.example.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {
    // In Here need to mention the primary key
    @Id
    private int id;
    private String name;
    private String address;
}
