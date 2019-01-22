package com.avin.questo.controller;

import com.avin.questo.model.QuestoAnswers;
import com.avin.questo.model.UserDetails;
import com.avin.questo.service.QuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping(value = "/v1/rest")
@RestController
public class QuestoController {

    @Autowired
    QuestoService service;
    List<String> questions;
    List<String> answers;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public List<String> getQuestions() {

        List<String> questions;
        questions = service.getQuestions();
        return questions;
    }

    @RequestMapping(value = "/questions/verify", method = RequestMethod.POST)
    public Boolean verifyAnswers(@RequestBody QuestoAnswers answers) {
        Boolean result=false;
        result = service.verifyAnswers(answers);
        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Boolean verifyAnswers(@RequestBody UserDetails userDetails) {
        Boolean result=false;
        result = service.register(userDetails);
        return result;
    }
}
