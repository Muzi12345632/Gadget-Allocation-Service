package com.example.demo.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "gadget_allocation")
public class GadgetAllocation {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //*@SequenceGenerator(name = "allocation_sequence",sequenceName = "allocation_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allocation_sequence")*//*
    private Long id;

    //one-to-one association

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gadget_id", referencedColumnName = "id")
    //@Column(insertable=false, updatable=false)
    //@Column(name = "serialNumber",nullable = false)
    private Gadget gadget;

    @Column(name = "location",nullable = false)
    private String location;

    //one-to-one association
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    //@Column(insertable=false, updatable=false)
    //@Column(name = "employeeNumber",nullable = false, length = 50)
    private Employee employee;

    @Column(name = "batteryLevel", nullable = false)
    private Float batteryLevel;


    @Column(name = "status",nullable = false)
    private Boolean status;

    @Column(name = "allocationDate", nullable = false)
    private Date date;

    public GadgetAllocation(Gadget gadget, String location, Employee employee, Float batteryLevel, Boolean status, Date date) {
        this.gadget = gadget;
        this.location = location;
        this.employee = employee;
        this.batteryLevel = batteryLevel;
        this.status = status;
        this.date = date;
    }

    public GadgetAllocation() {
    }

    public Gadget getSerialNumber() {
        return gadget;
    }

    public void setSerialNumber(Gadget serialNumber) {
        this.gadget = serialNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employee getEmployeeNumber() {
        return employee;
    }

    public void setEmployeeNumber(Employee employeeNumber) {
        this.employee = employeeNumber;
    }

    public Float getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Float batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
