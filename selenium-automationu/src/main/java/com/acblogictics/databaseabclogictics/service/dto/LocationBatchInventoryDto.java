package com.acblogictics.databaseabclogictics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationBatchInventoryDto {
    private Long id;
    private Long actualQty;
    private int palletCount;
    private Long batchId;
    private Long inboundReceiving_productDetailId;
    private Long locationId;
}
