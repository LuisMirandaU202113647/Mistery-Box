package com.upc.TrabajoFinalCRUD.service;

import com.upc.TrabajoFinalCRUD.model.Item;
import com.upc.TrabajoFinalCRUD.repository.ItemRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Transactional (readOnly = true)
    public Item getItem(Long itemId){
        return itemRepository.findById(itemId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el item con el Id "+itemId));

    }
    @Transactional
    public Item insertItem (Item itemDetalle){
        return itemRepository.save(itemDetalle);
    }
    @Transactional
    public Item delteItem (Long itemId){
        Item item=itemRepository.findById(itemId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el item con Id "+itemId));
        itemRepository.deleteById(itemId);
        return item;
    }

}
