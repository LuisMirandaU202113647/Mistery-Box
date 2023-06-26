package com.upc.TrabajoFinalCRUD.repository;

import com.upc.TrabajoFinalCRUD.model.entity.Customer;
import org.hibernate.annotations.SQLSelect;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM Customer p WHERE p.name LIKE %?1%",nativeQuery = true)
    public Optional<Customer> findByName(String customerName);
}
