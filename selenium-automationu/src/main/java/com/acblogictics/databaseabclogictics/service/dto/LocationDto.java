package com.acblogictics.databaseabclogictics.service.dto;


import com.acblogictics.databaseabclogictics.service.dto.request.LocationTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String locationNo;
    private int minCBM;
    private int maxCBM;
    private boolean status;
    private LocationTypeDto locationType;
}
