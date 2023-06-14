package com.upc.TrabajoFinalCRUD.controller;

import com.upc.TrabajoFinalCRUD.model.dto.OrderDTO;
import com.upc.TrabajoFinalCRUD.model.entity.Order;
import com.upc.TrabajoFinalCRUD.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Order> getById(@PathVariable(value = "id")Long orderId){
        return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<Order> insertOrder(@RequestBody OrderDTO orderDetails){
        return new ResponseEntity<Order>(orderService.insertOrder(orderDetails),HttpStatus.CREATED);
    }
}
