package com.IoT_basedMonitoringDashboard.IoT_basedMonitoringDashboard.Repository;

import com.IoT_basedMonitoringDashboard.IoT_basedMonitoringDashboard.Model.EquipmentData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentDataRepository extends MongoRepository<EquipmentData, String> {
    List<EquipmentData> findByEquipmentId(String equipmentId);
}
