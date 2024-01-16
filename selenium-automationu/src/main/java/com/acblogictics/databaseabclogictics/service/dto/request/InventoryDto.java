package com.acblogictics.databaseabclogictics.service.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto implements Serializable {
    private Long id;
    private double receivedMcQty;
    private double onHandMcQty;
    private double preFulfilledMcQty;
    private double fulfilledMcQty;
    private double receivedUnitQty;
    private double onHandUnitQty;
    private double preFulfilledUnitQty;
    private double fulfilledUnitQty;
}