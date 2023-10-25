package com.prediction.services;

import com.prediction.model.entities.response.QuestionResponse;

public interface QuestionsService {
    QuestionResponse getQuestionResponse(long id);
}
