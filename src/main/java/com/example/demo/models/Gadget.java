package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="gadget")
public class Gadget {

    @Id
    @SequenceGenerator(name = "gadget_sequence",sequenceName = "gadget_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gadget_sequence")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="SerialNumber",nullable = false, length = 50)
    private String serialNumber;

    @Column(name="model",nullable = false)
    private String model;

    @Embedded
    @Column(name="Location",nullable = false)
    private Locations Location;

    @Column(name="batteryLevel",nullable = false)
    private double batteryLevel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "gadget", referencedColumnName = "id")
    //@Column(name="maintenanceHistory",nullable = false)
    private List<GadgetMaintenanceHistory> maintenanceHistory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serialNumber", referencedColumnName = "id")
    private List<GadgetIssues> gadgetIssues;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gadget",referencedColumnName = "id")
    private Employee employee;

    public Gadget(String serialNumber, String model, Locations Location, double batteryLevel) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.Location = Location;
        this.batteryLevel = batteryLevel;
        //this.maintenanceHistory = maintenanceHistory;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<GadgetIssues> getGadgetIssues() {
        return gadgetIssues;
    }

    public void setGadgetIssues(List<GadgetIssues> gadgetIssues) {
        this.gadgetIssues = gadgetIssues;
    }

    public Gadget() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Locations getLocation() {
        return Location;
    }

    public void setLocation(Locations Location) {
        this.Location = Location;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public List<GadgetMaintenanceHistory> getMaintenanceHistory() {
        return maintenanceHistory;
    }

    public void setMaintenanceHistory(List<GadgetMaintenanceHistory> maintenanceHistory) {
        this.maintenanceHistory = maintenanceHistory;
    }

    // Method to add maintenance record
    public void addMaintenanceRecord(String record) {

        //GadgetMaintenanceHistory history = new GadgetMaintenanceHistory();
        //history.setDescription(record);

    }

}
