package com.ifmo.isdb;

import org.springframework.stereotype.Service;

@Service
public class Answer {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
