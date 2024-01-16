package com.acblogictics.databaseabclogictics.service.dto.request;

import com.acblogictics.databaseabclogictics.service.dto.CustomerDto;
import com.acblogictics.databaseabclogictics.service.dto.FileDTO;
import com.acblogictics.databaseabclogictics.service.dto.ProductPackagingDto;
import com.acblogictics.databaseabclogictics.service.dto.SKUDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductWithImages {
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
    private Set<FileDTO> images = new HashSet<>();
    private InventoryDto inventory;
}
