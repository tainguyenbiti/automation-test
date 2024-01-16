package com.acblogictics.databaseabclogictics.service.dto.response;

public interface ILocationInventoryDto {
    //get feilds for: location_id, location_no, location_type_name, inbound_receiving_no, total_qty
    Long getLocation_id();
    String getLocation_no();
    String getLocation_type_name();
    String getInbound_receiving_no();
    Long getTotal_qty();

}
