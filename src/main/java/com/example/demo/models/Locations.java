package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Embeddable
@Table(name="locations")
public class Locations {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false)
    //@SequenceGenerator(name = "location_sequence",sequenceName = "location_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    private Long id;

    @Column(name = "DistrictName",nullable = true, length = 255)
    private String districtName;

    @Column(name = "province_id",nullable = true)
    private BigInteger province_id;

    public Locations(Long id, String districtName, BigInteger province_id) {
        this.id = id;
        this.districtName = districtName;
        this.province_id = province_id;
    }

    public Locations() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict_name() {
        return districtName;
    }

    public void setDistrict_name(String district_name) {
        this.districtName = district_name;
    }

    public BigInteger getProvince_id() {
        return province_id;
    }

    public void setProvince_id(BigInteger province_id) {
        this.province_id = province_id;
    }

}
