package com.MultiSearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Workforce {

    @JsonProperty("WorkforceID")
    private String workforceID;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Shift")
    private String shift;


}
