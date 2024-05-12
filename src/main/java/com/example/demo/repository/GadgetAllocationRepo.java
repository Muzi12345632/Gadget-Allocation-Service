package com.example.demo.repository;


import com.example.demo.models.Gadget;
import com.example.demo.models.GadgetAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetAllocationRepo extends JpaRepository<GadgetAllocation, Long> {

    //Gadget allocateGadget(String serialNumber, String employeeName);

    //Gadget returnGadget(String serialNumber);

    //Gadget findByLocation(String location);

    GadgetAllocation save(GadgetAllocation gadgetAllocation);

    //Gadget updateGadgetBatteryLevel(String serialNumber, double batteryLevel);

}
