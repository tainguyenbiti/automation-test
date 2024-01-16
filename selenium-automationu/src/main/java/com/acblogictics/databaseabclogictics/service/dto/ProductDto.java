package com.acblogictics.databaseabclogictics.service.dto;

import com.acblogictics.databaseabclogictics.service.dto.request.InventoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Long id;
    private String productNo;
    private CustomerDto customer;
    private String name;
    private String upc;
    private Date createdDate = new Date();
    private Date lastModifiedDate = new Date();
    private Set<SKUDto> skus = new HashSet<>();
    private boolean status;
    private boolean stockStatus;
    private String color;
    private String description;
    private String note;
    private ProductPackagingDto productPackaging;
    private Set<ProductImageDto> images = new HashSet<>();
    private InventoryDto inventory;
}