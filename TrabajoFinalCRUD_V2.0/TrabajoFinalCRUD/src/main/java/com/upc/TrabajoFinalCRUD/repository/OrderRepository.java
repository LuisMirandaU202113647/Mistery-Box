package com.upc.TrabajoFinalCRUD.repository;

import com.upc.TrabajoFinalCRUD.model.entity.Order;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
