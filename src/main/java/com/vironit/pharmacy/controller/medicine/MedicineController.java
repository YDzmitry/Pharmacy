package com.vironit.pharmacy.controller.medicine;


import com.vironit.pharmacy.model.medicine.Medicine;
import com.vironit.pharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MedicineController {

    @Autowired
    MedicineService medicineService;


    @CrossOrigin
    @PostMapping("/admin/medicine/save")
    public ResponseEntity<?> saveMedicine(@RequestBody Medicine medicine) {
        long id = medicineService.save(medicine);
        return ResponseEntity.ok().body("New Medicine has been saved with ID:" + id);
    }

    @CrossOrigin
    @GetMapping("/admin/medicine/get/{id}")
    public ResponseEntity<?> getMedicine(@PathVariable("id") long id) {
        Medicine medicine = medicineService.getByPK(id);
        return ResponseEntity.ok().body(medicine);
    }


    @PutMapping("/admin/medicine/update/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable("id") long id, @RequestBody Medicine medicine) {
        medicineService.update(medicine);
        return ResponseEntity.ok().body("Medicine has been updated " + id);
    }


    @DeleteMapping("/medicine/delete/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable("id") long id) {
        medicineService.delete(id);
        return ResponseEntity.ok().body("Medicine has been deleted" + id);
    }
}
