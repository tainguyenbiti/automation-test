package com.acblogictics.databaseabclogictics.service.dto;

import com.acblogictics.databaseabclogictics.service.dto.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ProductImage}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageDto implements Serializable {
    private Long id;
    private String link;
    private String text;
    private FileDTO productImage;
}