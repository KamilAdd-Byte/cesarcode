package com.bazarek.bazarek.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "street_name",nullable = false,length = 50)
    private String streetName;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "flat_number")
    private int flatNumber;

    @Column(name = "zip_code")
    private String zipCode;
}
