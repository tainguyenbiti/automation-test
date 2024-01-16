package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryUpDateReq {
    private Long id;
    private double receivedMcQtyUpdate;
    private double onHandMcQtyUpdate;
    private double preFulfilledMcQtyUpdate;
    private double fulfilledMcQtyUpdate;
    private double receivedUnitQtyUpdate;
    private double onHandUnitQtyUpdate;
    private double preFulfilledUnitQtyUpdate;
    private double fulfilledUnitQtyUpdate;
}
