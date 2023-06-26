package com.upc.TrabajoFinalCRUD.repository;

import com.upc.TrabajoFinalCRUD.model.entity.Order;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT o.* FROM order_mb o JOIN Customer c ON c.id=o.customer_id WHERE c.id=:customerId",nativeQuery = true)
    public List<Order> getOrderByCustomerId(Long customerId);
}
