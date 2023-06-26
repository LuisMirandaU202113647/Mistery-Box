package com.upc.TrabajoFinalCRUD.repository;

import com.upc.TrabajoFinalCRUD.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
