package com.example.demo.models;



import jakarta.persistence.*;

@Entity
@Table(name="gadget_issues")
public class GadgetIssues {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //*@SequenceGenerator(name = "issue_sequence",sequenceName = "issue_sequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issue_sequence")*//*
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "issue_id", referencedColumnName = "id")
    //@Column(name="serialNumber", nullable = false)
    private Gadget gadget;

    @Column(name="Issue", nullable = false)
    private String Issue;

    public GadgetIssues(Gadget gadget, String issue) {
        this.gadget = gadget;
        this.Issue = issue;
    }

    public Gadget getGadget() {
        return gadget;
    }

    public void setGadget(Gadget gadget) {
        this.gadget = gadget;
    }

    public GadgetIssues() {
    }

    public Gadget getSerialNumber() {
        return gadget;
    }

    public void setSerialNumber(Gadget gadget) {
        this.gadget = gadget;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String issue) {
        Issue = issue;
    }

    public void save(GadgetIssues issue) {

    }

}
