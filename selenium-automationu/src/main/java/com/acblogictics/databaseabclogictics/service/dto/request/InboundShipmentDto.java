package com.acblogictics.databaseabclogictics.service.dto.request;

import com.acblogictics.databaseabclogictics.service.dto.CustomerDto;
import com.acblogictics.databaseabclogictics.service.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.InboundShipment}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InboundShipmentDto implements Serializable {
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
    private boolean isDeleted;
    private Set<InboundShipmentProductDetailDto> inboundShipmentDetail;
}