package com.acblogictics.databaseabclogictics.service.dto.response;

public interface IProductScanInLocationDto {
    //get fields for : total_actual_qty, total_pallet_count, location_id, product_name, location_type_name, location_no

    Long getTotal_actual_qty();
    Long getTotal_pallet_count();
    Long getLocation_id();
    String getProduct_name();
    String getLocation_type_name();
    String getLocation_no();

}
