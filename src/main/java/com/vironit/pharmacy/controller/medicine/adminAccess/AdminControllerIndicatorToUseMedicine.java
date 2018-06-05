package com.vironit.pharmacy.controller.medicine.adminAccess;

import com.vironit.pharmacy.model.medicine.IndicatorToUse;
import com.vironit.pharmacy.service.adminService.AdminServiceIndicatorToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class AdminControllerIndicatorToUseMedicine {

    @Autowired
    AdminServiceIndicatorToUse adminServiceIndicator;

    @PostMapping("/admin/indicatorToUse/save")
    public ResponseEntity<?> saveIndicatorToUse(@RequestBody IndicatorToUse indicatorToUse) {
        long id = adminServiceIndicator.save(indicatorToUse);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/admin/indicatorToUse/update/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable("id") long id, @RequestBody IndicatorToUse indicatorToUse) {
        adminServiceIndicator.update(indicatorToUse);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/admin/indicatorToUse/delete/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable("id") long id) {
        adminServiceIndicator.delete(id);
        return ResponseEntity.ok().body("IndicatorToUse has been deleted" + id);
    }
}
