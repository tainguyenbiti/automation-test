package com.acblogictics.databaseabclogictics.service.dto.request;


import com.acblogictics.databaseabclogictics.service.dto.InboundReceivingDto;
import com.acblogictics.databaseabclogictics.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundReceivingProductDetailDto {
    private Long id;
    private double actualMC;
    private double actualUc;
    private double totalUnit;
    private double totalMcWeight;
    private ProductDto product;
    private double tiXHi;
    private Set<BatchLocationDto> locationBatches;
    private InboundReceivingDto inboundReceiving;
    private double expectedMC;
    private double expectedUc;
}
