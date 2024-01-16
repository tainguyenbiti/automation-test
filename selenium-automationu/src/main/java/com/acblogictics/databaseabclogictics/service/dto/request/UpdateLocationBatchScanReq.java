package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLocationBatchScanReq {
    private Long id;
    private Double actualMC;
    private Double actualUC;
    private Double totalUnit;
    private Set<BatchLocationDto> locationBatches = new HashSet<>();
}
