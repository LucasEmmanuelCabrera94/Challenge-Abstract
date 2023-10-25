package com.prediction.model.entities.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prediction.model.entities.Forecast;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ForecastResponse {
    private Forecast forecast;
    private String error;
}
