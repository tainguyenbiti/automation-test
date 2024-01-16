package com.acblogictics.databaseabclogictics.service.dto.request;

import com.acblogictics.databaseabclogictics.service.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.InboundShipmentProductDetail}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundShipmentProductDetailDto implements Serializable {
    private Long id;
    private double expectedMC;
    private double expectedUc;
    private double totalUnit;
    private double totalMcWeight;
    private ProductDto product;
}