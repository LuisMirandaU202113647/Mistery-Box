package com.upc.TrabajoFinalCRUD.service;

import com.upc.TrabajoFinalCRUD.model.entity.MysteryBox;
import com.upc.TrabajoFinalCRUD.model.entity.Order;
import com.upc.TrabajoFinalCRUD.repository.ItemRepository;
import com.upc.TrabajoFinalCRUD.repository.MysteryBoxRepository;
import com.upc.TrabajoFinalCRUD.repository.OrderRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Transactional (readOnly = true)
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Order getOrderById(Long orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encuentra la orden con Id "+orderId));
    }

}
