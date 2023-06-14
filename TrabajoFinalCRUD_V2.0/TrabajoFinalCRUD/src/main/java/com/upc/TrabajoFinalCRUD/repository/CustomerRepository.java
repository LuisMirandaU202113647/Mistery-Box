package com.upc.TrabajoFinalCRUD.repository;

import com.upc.TrabajoFinalCRUD.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
