package com.prediction.validators;

import org.springframework.stereotype.Component;

@Component
public class ValidatorController {
    private int maxDays = 3650;
    public void validateRequestParam(int requestParam) throws IllegalAccessException {
        if (requestParam < 1 || requestParam > maxDays){
            throw new IllegalAccessException("El dia que se quiere consultar no esta dentro los dias posibles a consultar.");
        }
    }
}
