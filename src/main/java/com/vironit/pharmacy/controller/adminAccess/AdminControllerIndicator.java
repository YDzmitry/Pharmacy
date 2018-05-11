package com.vironit.pharmacy.controller.adminAccess;

import com.vironit.pharmacy.model.medicine.IndicatorToUse;
import com.vironit.pharmacy.service.adminService.AdminServiceIndicatorToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Scope("request")
@RestController
public class AdminControllerIndicator {

    @Autowired
    AdminServiceIndicatorToUse adminServiceIndicator;

    @PostMapping("/indicatorToUse/save")
    public ResponseEntity<?> saveIndicatorToUse(@RequestBody IndicatorToUse indicatorToUse) {
        long id = adminServiceIndicator.save(indicatorToUse);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/indicatorToUse/update/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable("id") long id,@RequestBody IndicatorToUse indicatorToUse){
        adminServiceIndicator.update(indicatorToUse);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/indicatorToUse/delete/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable("id") long id){
        adminServiceIndicator.delete(id);
        return ResponseEntity.ok().body("IndicatorToUse has been deleted" + id);
    }
}
