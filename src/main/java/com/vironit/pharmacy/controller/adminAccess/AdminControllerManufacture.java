package com.vironit.pharmacy.controller.adminAccess;

import com.vironit.pharmacy.model.medicine.Manufacture;
import com.vironit.pharmacy.service.adminService.AdminServiceManufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Scope("request")
@RestController
public class AdminControllerManufacture {

    @Autowired
    AdminServiceManufacture adminServiceManufacture;

    @PostMapping("/manufacture/save")
    public ResponseEntity<?> saveManufacture(@RequestBody Manufacture manufacture) {
        long id = adminServiceManufacture.save(manufacture);
        return ResponseEntity.ok().body(id);
    }


    @GetMapping("/manufacture/get/{id}")
    public ResponseEntity<Manufacture> getManufactureById(@PathVariable("id") long id) {
        Manufacture manufacture = adminServiceManufacture.getByPK(id);
        return ResponseEntity.ok().body(manufacture);
    }

    @PutMapping("/manufacture/update/{id}")
    public ResponseEntity<?> updateManufacture(@PathVariable("id") long id,@RequestBody Manufacture manufacture){
        adminServiceManufacture.update(manufacture);
        return ResponseEntity.ok().body(id);
    }

    @DeleteMapping("/manufacture/delete/{id}")
    public ResponseEntity<?> deleteManufacture(@PathVariable("id") long id){
        adminServiceManufacture.delete(id);
        return ResponseEntity.ok().body("Manufacture has been deleted" + id);
    }

}
