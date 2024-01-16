package com.acblogictics.databaseabclogictics.service.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link ShipAddress}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipAddressDto implements Serializable {
    Long id;
    String address1;
    String address2;
    String city;
    String state;
    String zipcode;
    String country;
}