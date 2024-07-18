package com.upc.TrabajoFinalCRUD.model.entity;

import com.upc.TrabajoFinalCRUD.model.entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mistery_box")
public class MysteryBox {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne()
    @JoinColumn(name="idItem")
    private Item item;
    private String name;
    private Long price;
    private String description;
    private Long stock;
    private String supermarket;
    private Long stars;
    private String date;
}
