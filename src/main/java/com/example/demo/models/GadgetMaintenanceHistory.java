package com.example.demo.models;


import jakarta.persistence.*;

@Entity
@Table(name="gadgetmaintenancehistory")
public class GadgetMaintenanceHistory {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //*@SequenceGenerator(name = "history_sequence",sequenceName = "history_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "history_sequence")*//*
    private Long id;

    //@Column(name="serialNumber", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maintenance_id", referencedColumnName = "id")
    //@JoinColumn(name = "gadget_id")
    private Gadget gadget;

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }

    @Column(name = "description", nullable = false)
    private String Description;

    public GadgetMaintenanceHistory(Gadget gadget, String description) {
        this.gadget = gadget;
        this.Description = description;
    }

    public GadgetMaintenanceHistory() {
    }

    /*public Gadget getSerialNumber() {
        return gadget;
    }

    public void setSerialNumber(Gadget gadget) {
        this.gadget = gadget;
    }*/

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
