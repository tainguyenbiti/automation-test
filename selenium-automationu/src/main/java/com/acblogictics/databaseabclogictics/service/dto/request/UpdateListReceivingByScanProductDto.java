package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateListReceivingByScanProductDto {
    private Long productId;
    private Long containerNo;
    private Double actualMC;
    private Double actualUC;
    private Double totalUnit;
    private List<BatchLocationDto> locationBatches ;
}
