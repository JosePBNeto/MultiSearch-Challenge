package com.MultiSearch.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SalesOrder {

    @JsonProperty("SalesOrderID")
    private String salesOrderID;

    @JsonProperty("DeliveryDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date deliveryDate;

    @JsonProperty("Customer")
    private String customer;

    @JsonProperty("MaterialID")
    private String materialID;

    @JsonProperty("MaterialName")
    private String materialName;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("TotalValue")
    private float totalValue;


}
