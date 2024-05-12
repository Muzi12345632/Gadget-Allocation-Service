package com.example.demo.controllers;


import com.example.demo.models.Employee;
import com.example.demo.models.Gadget;
import com.example.demo.models.GadgetAllocation;
import com.example.demo.models.Locations;
import com.example.demo.repository.*;
import com.example.demo.service.Gadgetservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class Systemallocation{

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    GadgetRepo gadgetRepo;

    @Autowired
    Gadgetservice gadgetservice;

    @Autowired
    LocationsRepo locationsRepo;

    @Autowired
    GadgetAllocationRepo gadgetAllocationRepo;



    @PostMapping("api/v1/new")
    public void createEmployee(@RequestBody Employee employee){
        gadgetservice.newEmployee(employee);
    };

    @PostMapping("api/v1/newGadget")
    public void createGadget(@RequestBody Gadget gadget){
        gadgetRepo.save(gadget);
    };

    @PostMapping("api/v1/newLocation")
    public void createGadget(@RequestBody Locations location){
        locationsRepo.save(location);
    };

    @GetMapping("api/v1/employees")
    public List<Employee> findEmployee(){
        return employeeRepo.findAll();
    }

    @PostMapping("api/v1/AllocateGadget")
    public void allocateGadget(@PathVariable String serialNumber,@RequestBody String employeeName){
        gadgetservice.allocateGadget(serialNumber,employeeName);
    }

    @PostMapping("api/v1/RecordGadgetMaintenance")
    public void maintenance(@PathVariable String serialNumber,@RequestBody String maintenanceRecord){
        gadgetservice.recordMaintenance(serialNumber,maintenanceRecord);
    }

    @PostMapping("api/v1/ReportGadgetIssue")
    public void newIssue(@PathVariable String serialNumber, @RequestBody String issue){
            //return gadgetIssuesRepo.;
        gadgetservice.reportIssue(serialNumber,issue);
    }

    @PostMapping("api/v1/updateGadgetLocation")
    public void updateLocation( @PathVariable String serialNumber, @RequestBody Locations location){
        gadgetservice.updateGadgetLocation(serialNumber, location);
    }

    @PostMapping("api/v1/updateBatteryLevel")
    public void newIssue(@RequestBody String serialNumber, Double batteryLevel){
        gadgetservice.updateGadgetBatteryLevel(serialNumber,batteryLevel);
    }

    @GetMapping("api/v1")
    public List<Gadget> findGadget(){
        return gadgetRepo.findAll();
    }


    @GetMapping("api/v1/allocatedGadget")
    public List<GadgetAllocation> findAllocatedGadget(){
        return gadgetAllocationRepo.findAll();
    }


    @GetMapping("api/v1/Employee/{name}")
    public Employee findEmployee(@PathVariable String name){
        return gadgetservice.findEmployee(name);
    }


    @GetMapping("api/v1/Gadget/{serialNumber}")
    public Gadget findDevice(@PathVariable String serialNumber){
        return gadgetservice.getDevice(serialNumber);
    }


}
