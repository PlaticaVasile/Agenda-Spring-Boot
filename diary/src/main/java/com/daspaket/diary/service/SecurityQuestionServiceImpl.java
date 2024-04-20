package com.daspaket.diary.service;

import com.daspaket.diary.model.SecurityQuestion;
import com.daspaket.diary.repository.SecurityQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityQuestionServiceImpl implements SecurityQuestionService
{
    //
    @Autowired
    private SecurityQuestionRepository repo;
    @Override
    public List<SecurityQuestion> getAllQuestions()
    {
        //
        return repo.findAll();
    }
}
