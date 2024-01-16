package com.acblogictics.databaseabclogictics.service.dto.request;

import com.acblogictics.databaseabclogictics.service.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchLocationDto {
    private Long id;
    private BatchDto batch;
    private LocationDto location;
    private int actualQTY;
    private int palletCount;
}
