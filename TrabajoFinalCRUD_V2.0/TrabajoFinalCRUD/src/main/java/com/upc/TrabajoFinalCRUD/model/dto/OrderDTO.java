package com.upc.TrabajoFinalCRUD.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO implements Serializable {
    private Long Id;
    private Long mysteryBoxId;
    private Long customerId;
    private String date;

}
