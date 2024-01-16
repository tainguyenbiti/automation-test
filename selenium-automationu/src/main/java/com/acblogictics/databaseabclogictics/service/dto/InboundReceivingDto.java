package com.acblogictics.databaseabclogictics.service.dto;

import com.acblogictics.databaseabclogictics.service.dto.request.InboundReceivingProductDetailDto;
import com.acblogictics.databaseabclogictics.service.dto.request.InboundShipmentProductDetailDto;
import com.acblogictics.databaseabclogictics.service.dto.request.ShipAddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundReceivingDto {
    private Long id;
    private CustomerDto customer;
    private Long containerNo;
    private Long vessel;
    private String masterBillOfLading;
    private Date eta;
    private Date etd;
    private Long refNo;
    private String shipmentStatus;
    private ShipAddressDto shipFromAddress;
    private ShipAddressDto shipToAddress;
    private UserDto user;
    private String lastUpdateBy;
    private String note;
    private double totalMc;
    private double totalMcWeight;
    private double totalMcCBM;
    private double totalUnit;
    private String inboundShipmentNo;
    private String inboundReceivingNo;
    private Set<InboundReceivingProductDetailDto> inboundReceivingProductDetail;
    private Date createdDate;
    private Date lastModifiedDate;
}
