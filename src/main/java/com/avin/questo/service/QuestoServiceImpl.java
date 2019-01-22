package com.avin.questo.service;

import com.avin.questo.model.QuestoAnswers;
import com.avin.questo.model.TemplateAnswers;
import com.avin.questo.model.TemplateQuestions;
import com.avin.questo.model.UserDetails;
import com.avin.questo.utility.Encrypt;
import com.avin.questo.utility.SendMail;
import com.avin.questo.utility.ValidateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuestoServiceImpl implements QuestoService {


    List<Integer> questionIndex;
    List<String> selectedQuestions = new ArrayList<>();
    List<String> selectedAnswers = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(QuestoServiceImpl.class);

    @Override
    public List<String> getQuestions() {
        List<String> allQuestions;
        List<String> allAnswers;

        TemplateQuestions questBuilder = new TemplateQuestions();
        TemplateAnswers ansBuilder = new TemplateAnswers();

        allQuestions = questBuilder.fillQuestions();
        allAnswers = ansBuilder.getAnswers();
        selectedQuestions.clear();
        selectedAnswers.clear();
        int randomNumber = 0;
        questionIndex = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            randomNumber = getRandomNumber(allQuestions.size());


            selectedQuestions.add(allQuestions.get(randomNumber));
            selectedAnswers.add(allAnswers.get(randomNumber));
            questionIndex.add(randomNumber);

        }
        logger.info(String.valueOf(questionIndex));

        return selectedQuestions;
    }

    @Override
    public Boolean verifyAnswers(QuestoAnswers answers) {
        Boolean result = false;
        List<String> userAnswer = new ArrayList<>();
        userAnswer.add(answers.getAnswer1());
        userAnswer.add(answers.getAnswer2());
        userAnswer.add(answers.getAnswer3());
        userAnswer.add(answers.getAnswer4());
        userAnswer.add(answers.getAnswer5());
        for (int i = 0; i < selectedAnswers.size(); i++) {
            result = checkAnswer(selectedAnswers.get(i), userAnswer.get(i));
            if (!result) {
                break;
            }
        }
        selectedQuestions.clear();
        selectedAnswers.clear();

        return result;
    }

    @Override
    public Boolean register(UserDetails userDetails) {
        Boolean result = false;
        ValidateUser validateUser = new ValidateUser();
        result = validateUser.validateUser(userDetails);
        if (!result)
            return result;

        Encrypt enc = new Encrypt();
        SendMail sendMail = new SendMail();

        try {
            enc.cryptWithMD5(userDetails.getPassword());
            sendMail.sendMyMail(userDetails.getEmail());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }
    }

    private int getRandomNumber(int size) {

        return (int) Math.floor(Math.random() * 1000) % size;

    }

    private Boolean checkAnswer(String answer, String index) {

        if (answer.equalsIgnoreCase(index)) {
            return true;
        } else
            return false;
    }
}
