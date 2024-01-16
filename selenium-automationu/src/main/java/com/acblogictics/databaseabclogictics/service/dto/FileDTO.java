package com.acblogictics.databaseabclogictics.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.File}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO implements Serializable {
    private Long id;
    private String name;
    private String fileOnServer;
    private String relativePath;
    private String linkImage;
}