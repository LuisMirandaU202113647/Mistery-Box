package com.upc.TrabajoFinalCRUD.service;

import com.upc.TrabajoFinalCRUD.model.dto.MysteryBoxDTO;
import com.upc.TrabajoFinalCRUD.model.entity.Item;
import com.upc.TrabajoFinalCRUD.model.entity.MysteryBox;
import com.upc.TrabajoFinalCRUD.repository.ItemRepository;
import com.upc.TrabajoFinalCRUD.repository.MysteryBoxRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MysteryBoxService {
    @Autowired
    MysteryBoxRepository mysteryBoxRepository;
    @Autowired
    ItemRepository itemRepository;
    @Transactional(readOnly = true)
    public List<MysteryBox> getAllMysteryBoxes(){
        return mysteryBoxRepository.findAll();
    }
    @Transactional(readOnly = true)
    public MysteryBox getMysteryBoxById(Long mysteryBoxId){
        return mysteryBoxRepository.findById(mysteryBoxId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró la mystery box con el Id "+mysteryBoxId));
    }
    @Transactional
    public MysteryBox insertMysteryBox(MysteryBoxDTO mysteryBoxDetails){
        MysteryBox mysteryBox=new MysteryBox();
        Item item;
        mysteryBox.setName(mysteryBoxDetails.getName());
        mysteryBox.setPrice(mysteryBoxDetails.getPrice());
        mysteryBox.setDescription(mysteryBoxDetails.getDescription());
        mysteryBox.setStock(mysteryBoxDetails.getStock());
        mysteryBox.setSupermarket(mysteryBoxDetails.getSupermarket());
        mysteryBox.setStars(mysteryBoxDetails.getStars());
        mysteryBox.setDate(mysteryBoxDetails.getDate());
        item=itemRepository.findById(mysteryBoxDetails.getItemId())
                        .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el item con el Id "+mysteryBoxDetails.getItemId()));
        mysteryBox.setItem(item);
        return mysteryBoxRepository.save(mysteryBox);
    }

}
