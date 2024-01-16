package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.ShipAddress}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipAddressDto implements Serializable {
    private Long id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}