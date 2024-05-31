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
public class PurchaseOrder {
    @JsonProperty("PurchaseOrderID")
    private String purchaseOrderID;

    @JsonProperty("DeliveryDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private Date deliveryDate;

    @JsonProperty("Supplier")
    private String supplier;

    @JsonProperty("MaterialID")
    private String materialID;

    @JsonProperty("MaterialName")
    private String materialName;

    @JsonProperty("Quantity")
    private int quantity;

    @JsonProperty("TotalCost")
    private float totalCost;


}
