package com.hanoi.heat.idrive.controller;

import com.hanoi.heat.idrive.model.OrderDetail;
import com.hanoi.heat.idrive.model.User;
import com.hanoi.heat.idrive.service.OrderDetail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@RestController
@CrossOrigin("*")
@RequestMapping("/Order")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<Iterable<OrderDetail>> findAllByUser(@RequestBody Long ownerId){
        return new ResponseEntity<>(orderDetailService.findByOwn(ownerId),HttpStatus.OK);
    }

    @PostMapping("/findByDate")
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

    @PostMapping("/findBetween/{date}/{ownerId}")
    public ResponseEntity<Iterable<OrderDetail>> findBetween(@PathVariable("date") Date date, @PathVariable("ownerId") Long ownerId){
        return new ResponseEntity<>(orderDetailService.findBetween(date, ownerId),HttpStatus.OK);
    }
}
