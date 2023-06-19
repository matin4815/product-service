package com.matin.productservice.dal.entity.referencedata;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "typs")
@Data
public class Type {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
