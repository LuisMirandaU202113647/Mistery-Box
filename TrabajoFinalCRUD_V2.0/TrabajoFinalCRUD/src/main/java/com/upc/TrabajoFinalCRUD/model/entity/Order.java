package com.upc.TrabajoFinalCRUD.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_mb")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne()
    @JoinColumn(name="mysteryBoxId")
    private MysteryBox mysteryBox;
    @ManyToOne()
    @JoinColumn(name="customerId")
    private Customer customer;
    private String date;
    private Long totalPrice;

}
