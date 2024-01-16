package com.acblogictics.databaseabclogictics.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto implements Serializable {
    private Long id;
    private Long receivedMcQty;
    private Long onHandMcQty;
    private Long preFulfilledMcQty;
    private Long fulfilledMcQty;
    private Long receivedUnitQty;
    private Long onHandUnitQty;
    private Long preFulfilledUnitQty;
    private Long fulfilledUnitQty;
}