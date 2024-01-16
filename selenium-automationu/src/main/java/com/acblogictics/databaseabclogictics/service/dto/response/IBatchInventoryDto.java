package com.acblogictics.databaseabclogictics.service.dto.response;

public interface IBatchInventoryDto {

    //get feilds for :id, batch_id, actual_qty, batch_no, location_id, location_no, location_type_name, product_id, inbound_receiving_no,created_date
    Long getId();
    Long getBatch_id();
    Long getActual_qty();
    String getBatch_no();
    Long getLocation_id();
    String getLocation_no();
    String getLocation_type_name();
    Long getProduct_id();
    String getInbound_receiving_no();
    String getCreated_date();


}
