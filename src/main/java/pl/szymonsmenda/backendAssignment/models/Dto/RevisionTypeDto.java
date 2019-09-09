package pl.szymonsmenda.backendAssignment.models.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RevisionTypeDto {

    @JsonProperty("add")
    ADD,

    @JsonProperty("mod")
    MOD,

    @JsonProperty("del")
    DEL
}
