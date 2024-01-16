package com.acblogictics.databaseabclogictics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.SKU}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SKUDto implements Serializable {
    private Long id;
    private String name;
}