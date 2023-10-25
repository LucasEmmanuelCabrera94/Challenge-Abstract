package com.prediction.validators;

import com.prediction.repositories.PredictionRepository;
import com.prediction.repositories.WeatherRepository;
import com.prediction.utils.Builders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)

public class ValidatorControllerTest {

    @Test
    public void validateRequestFailedTest(){
        ValidatorController validator = new ValidatorController();
        assertThrows(IllegalAccessException.class, () -> {
            validator.validateRequestParam(0);
        });
    }
    @Test
    public void validateRequestSuccessTest(){
        ValidatorController validator = new ValidatorController();
        assertDoesNotThrow( () -> {
            validator.validateRequestParam(27);
        });
    }
}
