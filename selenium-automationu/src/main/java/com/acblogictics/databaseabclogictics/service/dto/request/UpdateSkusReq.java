package com.acblogictics.databaseabclogictics.service.dto.request;

import com.acblogictics.databaseabclogictics.service.dto.SKUDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSkusReq {
    private Long id;
    private Set<SKUDto> skus = new HashSet<>();

}
