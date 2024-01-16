package com.acblogictics.databaseabclogictics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.ProductPackaging}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPackagingDto implements Serializable {
    private Long id;
    private Long size;
    private Long mcVolume;
    private Long mcNetWeight;
    private Long mcShipment;
    private Long mcLength;
    private Long mcWidth;
    private Long mcHeight;
    private Long uVolume;
    private Long uNetWeight;
    private Long uShipment;
    private Long uLength;
    private Long uWidth;
    private Long uHeight;
}