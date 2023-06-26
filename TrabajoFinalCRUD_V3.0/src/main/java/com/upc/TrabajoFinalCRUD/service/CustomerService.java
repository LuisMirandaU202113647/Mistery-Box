package com.upc.TrabajoFinalCRUD.service;

import com.upc.TrabajoFinalCRUD.model.entity.Customer;
import com.upc.TrabajoFinalCRUD.repository.CustomerRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Transactional (readOnly = true)
    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el cliente con Id "+customerId));
    }
    @Transactional (readOnly = true)
    public Customer getCustomerByName(String customerName){
        return customerRepository.findByName(customerName)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el cliente con el nombre "+customerName));
    }
    @Transactional
    public Customer insertCustomer (Customer customerDetalle) {
        return customerRepository.save(customerDetalle);
    }
    @Transactional
    public Customer updateCustomer (Long customerId,Customer customerDetalle){
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No existe cliente con el Id "+customerId));
            customer.setName(customerDetalle.getName());
            customer.setEmail(customerDetalle.getEmail());
            customer.setPassword(customerDetalle.getPassword());
            customer.setPhonenumber(customerDetalle.getPhonenumber());
            return customerRepository.save(customer);
    }
    @Transactional
    public Customer deleteCustomer (Long customerId){
        Customer customer=customerRepository.findById(customerId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No existe cliente con el Id "+customerId));
        customerRepository.deleteById(customerId);
        return customer;
    }
}
