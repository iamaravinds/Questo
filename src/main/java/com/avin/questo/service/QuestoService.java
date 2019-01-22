package com.avin.questo.service;


import com.avin.questo.model.QuestoAnswers;
import com.avin.questo.model.UserDetails;

import java.util.List;


public interface QuestoService {

    List<String> getQuestions();

    Boolean verifyAnswers(QuestoAnswers answers);
    Boolean register(UserDetails userDetails);

}
