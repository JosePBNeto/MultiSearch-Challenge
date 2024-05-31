package com.MultiSearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Equipment {
    @JsonProperty("EquipmentID")
    private String equipmentID;

    @JsonProperty("EquipmentName")
    private String equipmentName;
}
