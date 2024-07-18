package com.upc.TrabajoFinalCRUD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MysteryBoxDTO implements Serializable {
    private Long Id;
    private Long itemId;
    private String name;
    private Long price;
    private String description;
    private Long stock;
    private String supermarket;
    private Long stars;
    private String date;
}
