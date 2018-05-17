package com.vironit.pharmacy.controller.order;


import com.vironit.pharmacy.model.order.Order;
import com.vironit.pharmacy.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;


    @PostMapping("/order/save")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) {
        long id = orderService.save(order);
        return ResponseEntity.ok().body("New Order has been saved with ID:" + id);
    }


    @GetMapping("/order/get/{id}")
    public ResponseEntity<?> getOrder(@PathVariable("id") long id) {
        Order order = orderService.getByPK(id);
        return ResponseEntity.ok().body(order);
    }


    @PutMapping("/order/update/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable("id") long id, @RequestBody Order order) {
        orderService.update(order);
        return ResponseEntity.ok().body("Order has been updated " + id);
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<?> deleteMedicine(@PathVariable("id") long id) {
        orderService.delete(id);
        return ResponseEntity.ok().body("Order has been deleted" + id);
    }
}