package com.acblogictics.databaseabclogictics.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * DTO for {@link com.acblogictics.databaseabclogictics.entity.Billing}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDto {
    private Long billingId;
    private String name;
    private String addressOne;
    private String addressTwo;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
