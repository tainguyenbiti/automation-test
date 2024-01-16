package com.acblogictics.databaseabclogictics.service.dto;


import com.acblogictics.databaseabclogictics.service.dto.request.BillingDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private Long customerId;
    private String customerNo;
    private String customerName;
    private BillingDto billing;
}