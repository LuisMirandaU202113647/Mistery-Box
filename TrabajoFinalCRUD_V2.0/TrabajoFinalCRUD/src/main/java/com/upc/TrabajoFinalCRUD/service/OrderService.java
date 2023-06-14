package com.upc.TrabajoFinalCRUD.service;

import com.upc.TrabajoFinalCRUD.model.dto.OrderDTO;
import com.upc.TrabajoFinalCRUD.model.entity.Customer;
import com.upc.TrabajoFinalCRUD.model.entity.MysteryBox;
import com.upc.TrabajoFinalCRUD.model.entity.Order;
import com.upc.TrabajoFinalCRUD.repository.CustomerRepository;
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
    @Autowired
    MysteryBoxRepository mysteryBoxRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Transactional (readOnly = true)
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Order getOrderById(Long orderId){
        return orderRepository.findById(orderId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encuentra la orden con Id "+orderId));
    }
    @Transactional
    public Order insertOrder(OrderDTO orderDetails){
        Order order=new Order();
        MysteryBox mysteryBox;
        Customer customer;
        order.setId(orderDetails.getId());
        mysteryBox=mysteryBoxRepository.findById(orderDetails.getMysteryBoxId())
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No se encuentra la mystery box con el Id "+orderDetails.getMysteryBoxId()));
        customer=customerRepository.findById(orderDetails.getCustomerId())
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encuentra el cliente con el Id "+orderDetails.getCustomerId()));
        order.setCustomer(customer);
        order.setMysteryBox(mysteryBox);
        order.setDate(orderDetails.getDate());
        order.setTotalPrice(mysteryBox.getPrice());
        return orderRepository.save(order);
    }
}
