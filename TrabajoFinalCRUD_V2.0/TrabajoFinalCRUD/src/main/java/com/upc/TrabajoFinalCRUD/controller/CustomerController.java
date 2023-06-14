package com.upc.TrabajoFinalCRUD.controller;

import com.upc.TrabajoFinalCRUD.model.entity.Customer;
import com.upc.TrabajoFinalCRUD.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping ("/name/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(value = "id") Long customerId){
        return new ResponseEntity<Customer>(customerService.getCustomer(customerId),HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.insertCustomer(customer),HttpStatus.CREATED);
    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Customer> updateCustomer (@PathVariable(value = "id") Long customerId, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customerId,customer),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteCustomer (@PathVariable(value = "id") Long customerId){
        return new ResponseEntity<Customer>(customerService.deleteCustomer(customerId),HttpStatus.OK);
    }
}
