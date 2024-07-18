package com.upc.TrabajoFinalCRUD.controller;

import com.upc.TrabajoFinalCRUD.model.entity.Item;
import com.upc.TrabajoFinalCRUD.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping ("/name/{id}")
    private ResponseEntity<Item> getItem (@PathVariable (value = "id")Long itemId){
        return new ResponseEntity<Item>(itemService.getItem(itemId), HttpStatus.OK);
    }
    @PostMapping("/insert")
    private ResponseEntity<Item> insertItem (@RequestBody Item itemDetalle){
        return new ResponseEntity<Item>(itemService.insertItem(itemDetalle), HttpStatus.CREATED);
    }
    @DeleteMapping ("/delete/{id}")
    private ResponseEntity<Item> deleteItem (@PathVariable (value = "id")Long itemId){
        return new ResponseEntity<Item>(itemService.delteItem(itemId), HttpStatus.OK);
    }
}
