package com.daspaket.diary.controller;

import com.daspaket.diary.model.SecurityQuestion;
import com.daspaket.diary.service.SecurityQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/security")
public class SecurityQuestionController
{
    //
    @Autowired
    SecurityQuestionService service;
    @GetMapping(path = "/all-questions")
    public List<SecurityQuestion> showAll()
    {
        return service.getAllQuestions();
    }
}
