package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchLocationWithoutReceiveReq {
    private Long productId;
    private BatchDto batch;
    private Set<BatchLocationDto> locationBatches;
}
