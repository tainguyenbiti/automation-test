package com.acblogictics.databaseabclogictics.service.dto.response;

public interface IProductReceivingDetailByContainerDto {
    //get feilds for: inbound_receiving_no, id, actual_qty, pallet_count, batch_id, inbound_receiving_product_detail_id, location_id, product_name, location_type_name, location_no
    Long getId();
    String getInbound_receiving_no();
    Long getActual_qty();
    Long getPallet_count();
    Long getBatch_id();
    Long getInbound_receiving_product_detail_id();
    Long getLocation_id();
    String getProduct_name();
    String getLocation_type_name();
    String getLocation_no();

}
