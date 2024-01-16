package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReceivingScanByIdReq {
    private Long id;
    private String inboundReceivingNo;
    private Set<InboundReceivingProductDetailDto> inboundReceivingProductDetail;
}
