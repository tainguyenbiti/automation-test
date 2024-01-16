package com.acblogictics.databaseabclogictics.service.dto.response;

public interface IProductInventoryDto {
    //get feilds for : product_id, upc, product_name, id, fulfilled_mc_qty, fulfilled_unit_qty, on_hand_mc_qty, on_hand_unit_qty, pre_fulfilled_mc_qty, pre_fulfilled_unit_qty, received_mc_qty, received_unit_qty, customer_id, customer_name
    Long getProduct_id();
    String getUpc();
    String getProduct_name();
    Long getId();
    Long getFulfilled_mc_qty();
    Long getfulfilled_unit_qty();
    Long getOn_hand_mc_qty();
    Long getOn_hand_unit_qty();
    Long getPre_fulfilled_mc_qty();
    Long getPre_fulfilled_unit_qty();
    Long getReceived_mc_qty();
    Long getReceived_unit_qty();
    Long getCustomer_id();
    String getCustomer_name();


}
