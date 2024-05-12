package com.example.demo.repository;

import com.example.demo.models.Employee;
import com.example.demo.models.GadgetMaintenanceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GadgetMaintenanceHistoryRepo extends JpaRepository<GadgetMaintenanceHistory, Long> {
    //void recordMaintenance(String serialNumber, String maintenanceRecord);
    GadgetMaintenanceHistory save(GadgetMaintenanceHistory gadgetMaintenanceHistory);

}
