package com.avin.questo.model;

import java.util.ArrayList;
import java.util.List;

public class TemplateQuestions {

    private List<String> questions;

    public List<String> fillQuestions(){
        questions= new ArrayList<>();
        questions.add("What is your name?");
        questions.add("What is your age?");
        questions.add("What is your gender?");
        questions.add("What is your father's name?");
        questions.add("What is your mother'sname?");
        questions.add("What is your fav color?");
        questions.add("What is your fav toy?");
        questions.add("What is your fav super hero?");
        questions.add("What is your fav car?");
        questions.add("What is your first school?");
        questions.add("What is your best friend name?");
        questions.add("What is your company name?");
        questions.add("What is your car name?");
        questions.add("What is your GirlFriend name?");
        return questions;
    }
}
