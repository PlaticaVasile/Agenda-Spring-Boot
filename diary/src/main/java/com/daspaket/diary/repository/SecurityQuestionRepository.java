package com.daspaket.diary.repository;

import com.daspaket.diary.model.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Integer>
{
    //
}
