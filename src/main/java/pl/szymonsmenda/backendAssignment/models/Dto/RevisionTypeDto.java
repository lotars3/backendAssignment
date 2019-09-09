// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

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
