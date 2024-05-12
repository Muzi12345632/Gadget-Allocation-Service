package com.example.demo.repository;

import com.example.demo.models.Employee;
import com.example.demo.models.Gadget;
import com.example.demo.models.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface GadgetRepo extends JpaRepository<Gadget, Long> {

    //List<Gadget> findByLocationDistrictName(String districtName);

    //Gadget getReferenceById(String serialNumber);

    Gadget save(Gadget gadget);

    Gadget findBySerialNumber(String serialNumber);

    //List<Gadget> getAllocatedGadgets();

    //Gadget updateGadgetLocation(String serialNumber, Locations location);

}
