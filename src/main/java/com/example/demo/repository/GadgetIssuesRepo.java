package com.example.demo.repository;

import com.example.demo.models.Gadget;
import com.example.demo.models.GadgetIssues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetIssuesRepo extends JpaRepository<GadgetIssues, Long> {

    //Gadget reportIssue(String serialNumber, String issue);

    GadgetIssues save(GadgetIssues gadgetIssues);

}
