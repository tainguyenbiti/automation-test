package com.acblogictics.databaseabclogictics.service.dto.response;

public interface IScanProductReceivingDetailDto {
    //get fields for: product_id, product_name, total_actual_mc, total_actual_uc, total_expected_mc, total_expected_uc, all_total_unit, upc
    Long getProduct_id();
    String getProduct_name();
    Long getTotal_actual_mc();
    Long getTotal_actual_uc();
    Long getTotal_expected_mc();
    Long getTotal_expected_uc();
    Long getAll_total_unit();
    String getUpc();

}
