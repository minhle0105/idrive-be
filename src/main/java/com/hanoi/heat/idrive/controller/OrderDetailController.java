package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.service.OrderDetail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/Order")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @PostMapping("findByDate")
    public ResponseEntity<?> findByVehicle(@RequestBody String date){
        return new ResponseEntity<>(orderDetailService.findByDate(date),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> History(@PathVariable Long id) {
        return new ResponseEntity<>(orderDetailService.History(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<>(orderDetailService.save(orderDetail), HttpStatus.OK);
    }
}
