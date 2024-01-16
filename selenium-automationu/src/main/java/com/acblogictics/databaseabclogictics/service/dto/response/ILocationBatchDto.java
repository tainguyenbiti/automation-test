package com.acblogictics.databaseabclogictics.service.dto.response;

public interface ILocationBatchDto {
    //get fields for : product_id, product_name, location_id, location_type_name, customer_name, location_no, actual_qty, batch_no, batch_id, upc, inbound_receiving_product_detail_id
    Long getProduct_id();
    String getProduct_name();
    Long getLocation_id();
    String getLocation_type_name();
    String getCustomer_name();
    String getLocation_no();
    Long getActual_qty();
    String getBatch_no();
    Long getBatch_id();
    String getUpc();
    Long getInbound_receiving_product_detail_id();

}
