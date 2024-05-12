package com.example.demo.repository;


import com.example.demo.models.Gadget;
import com.example.demo.models.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationsRepo extends JpaRepository<Locations, Long> {
    Locations save(Locations location);
}
