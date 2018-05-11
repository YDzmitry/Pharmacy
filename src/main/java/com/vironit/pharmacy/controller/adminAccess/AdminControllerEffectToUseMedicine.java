package com.vironit.pharmacy.controller.adminAccess;

import com.vironit.pharmacy.model.medicine.EffectToUse;
import com.vironit.pharmacy.service.adminService.AdminServiceEffectToUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Scope("request")
@RestController
public class AdminControllerEffectToUseMedicine {

    @Autowired
    AdminServiceEffectToUse adminServiceEffectToUse;

    @PostMapping("/effectToUse/save")
    public ResponseEntity<?> saveIndicatorToUse(@RequestBody EffectToUse effectToUse) {
        long id = adminServiceEffectToUse.save(effectToUse);
        return ResponseEntity.ok().body(id);
    }

    @PutMapping("/effectToUse/update/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable("id") long id,@RequestBody EffectToUse effectToUse){
        adminServiceEffectToUse.update(effectToUse);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/effectToUse/delete/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable("id") long id){
        adminServiceEffectToUse.delete(id);
        return ResponseEntity.ok().body("IndicatorToUse has been deleted" + id);
    }
}
