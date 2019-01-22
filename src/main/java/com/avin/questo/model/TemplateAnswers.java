package com.avin.questo.model;

import java.util.ArrayList;
import java.util.List;

public class TemplateAnswers {
    private List<String> answers;

    public TemplateAnswers(){
        answers = new ArrayList<>();
        answers.add("Aravind");
        answers.add("24");
        answers.add("Male");
        answers.add("Father's Name");
        answers.add("Mother's Name");
        answers.add("Blue");
        answers.add("Top");
        answers.add("Groot");
        answers.add("Volkswagen Beetle");
        answers.add("Kindergarden love");
        answers.add("Groot");
        answers.add("Grootan Technologies");
        answers.add("Ford Mustang");
        answers.add("I dont have one :P");

    }

    public List<String> getAnswers() {
        return answers;
    }
}
