package com.IoT_basedMonitoringDashboard.IoT_basedMonitoringDashboard.Controller;

import com.IoT_basedMonitoringDashboard.IoT_basedMonitoringDashboard.Model.EquipmentData;
import com.IoT_basedMonitoringDashboard.IoT_basedMonitoringDashboard.Repository.EquipmentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/equipmen")
public class EquipmentController {

    @Autowired
    private EquipmentDataRepository repository;

    @PostMapping("/adddata")
    public ResponseEntity<EquipmentData> saveEquipmentData(@RequestBody EquipmentData data){
        repository.save(data);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{equipmentId}")
    public ResponseEntity<List<EquipmentData>> getEquipmentData(@PathVariable String equipmentId){
        List<EquipmentData> data = repository.findByEquipmentId(equipmentId);
        if(data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }
    // New endpoint to fetch all equipment data
    @GetMapping("/all")
    public ResponseEntity<List<EquipmentData>> getAllEquipmentData() {
        List<EquipmentData> data = repository.findAll();
        if (data.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(data);
    }
}
