package com.upc.TrabajoFinalCRUD.controller;

import com.upc.TrabajoFinalCRUD.model.dto.MysteryBoxDTO;
import com.upc.TrabajoFinalCRUD.model.entity.MysteryBox;
import com.upc.TrabajoFinalCRUD.service.MysteryBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mysteryBox")
public class MysteryBoxController {
    @Autowired
    private MysteryBoxService mysteryBoxService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MysteryBox>> getAllMysteryBoxes(){
        return new ResponseEntity<List<MysteryBox>>(mysteryBoxService.getAllMysteryBoxes(), HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<MysteryBox> getMysteryBoxById(@PathVariable (value = "id")Long mysteryBoxId){
        return new ResponseEntity<MysteryBox>(mysteryBoxService.getMysteryBoxById(mysteryBoxId),HttpStatus.OK);
    }
    @PostMapping("/insert")
    public ResponseEntity<MysteryBox> insertMysteryBox(@RequestBody MysteryBoxDTO mysteryBoxDetails){
        return new ResponseEntity<MysteryBox>(mysteryBoxService.insertMysteryBox(mysteryBoxDetails),HttpStatus.CREATED);
    }

}
