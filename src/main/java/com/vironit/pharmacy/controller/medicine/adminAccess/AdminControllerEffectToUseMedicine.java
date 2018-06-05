package com.vironit.pharmacy.controller.medicine.adminAccess;

import com.vironit.pharmacy.model.medicine.EffectToUse;
import com.vironit.pharmacy.service.adminService.AdminServiceEffectToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AdminControllerEffectToUseMedicine {

    @Autowired
    AdminServiceEffectToUse adminServiceEffectToUse;


    @PostMapping("/admin/effectToUse/save")
    public ResponseEntity<?> saveIndicatorToUse(@RequestBody EffectToUse effectToUse) {
        long id = adminServiceEffectToUse.save(effectToUse);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/admin/effectToUse/update/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable("id") long id, @RequestBody EffectToUse effectToUse) {
        adminServiceEffectToUse.update(effectToUse);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/admin/effectToUse/delete/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable("id") long id) {
        adminServiceEffectToUse.delete(id);
        return ResponseEntity.ok().body("IndicatorToUse has been deleted" + id);
    }
}
