package com.example.demo.service;


import com.example.demo.models.*;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.GadgetAllocationRepo;
import com.example.demo.repository.GadgetIssuesRepo;
import com.example.demo.repository.GadgetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Gadgetservice {

    @Autowired
    GadgetRepo gadgetRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    GadgetAllocationRepo gadgetAllocationRepo;



    public Gadget getDevice(String serialNumber){
        return gadgetRepo.findBySerialNumber(serialNumber);
    }


    public  Employee newEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Gadget updateGadgetLocation(String SerialNumber, Locations location){
        Gadget gadget = gadgetRepo.findBySerialNumber(SerialNumber);
        gadget.setLocation(location);

        return gadgetRepo.save(gadget);
    }


    public Gadget updateGadgetBatteryLevel(String SerialNumber, Double batteryLevel){
        Gadget gadget = gadgetRepo.findBySerialNumber(SerialNumber);
        gadget.setBatteryLevel(batteryLevel);

        return gadgetRepo.save(gadget);
    }

    public GadgetAllocation allocateGadget(String SerialNumber, String employeeName){
        Gadget gadget = gadgetRepo.findBySerialNumber(SerialNumber);
        Employee employee = employeeRepo.findByName(employeeName);

        GadgetAllocation allocate = new GadgetAllocation();
        allocate.setSerialNumber(gadget);
        allocate.setEmployeeNumber(employee);

        //employee.setGadget(gadget);
        //employee.getGadget().add(gadget);
        //gadget.setEmployee(employee);

        employee.getGadget().add(gadget);

        return gadgetAllocationRepo.save(allocate);

    }

    public Gadget reportIssue(String SerialNumber, String issue){
        Gadget gadget = gadgetRepo.findBySerialNumber(SerialNumber);
        GadgetIssues Issues = new GadgetIssues();
        Issues.setGadget(gadget);
        Issues.setIssue(issue);

        // Add the issue to the gadget's list of issues
        gadget.getGadgetIssues().add(Issues);

        return gadgetRepo.save(gadget);
    }


    public Gadget recordMaintenance(String SerialNumber, String maintenanceRecord){
        Gadget gadget = gadgetRepo.findBySerialNumber(SerialNumber);
        GadgetMaintenanceHistory maintenance = new GadgetMaintenanceHistory();
        maintenance.setGadget(gadget);
        maintenance.setDescription(maintenanceRecord);

        gadget.getMaintenanceHistory().add(maintenance);

        return gadgetRepo.save(gadget);

    }

    public Employee findEmployee(String name){
        return employeeRepo.findByName(name);
    }
}
