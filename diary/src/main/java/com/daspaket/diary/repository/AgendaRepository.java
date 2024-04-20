package com.daspaket.diary.repository;

import com.daspaket.diary.model.Agenda;
import com.daspaket.diary.model.DataTransferObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AgendaRepository  extends JpaRepository<Agenda, Integer>
{
    @Modifying
    @Transactional
    @Query(value = "insert into Agenda(ID_User, Notes) " +
            "values ((select ID from User where Username = :username), :notes)", nativeQuery = true)
    void addPageRepo(@Param("username") String username, @Param("notes") String notes);

    @Query("select ID_User, Notes from Agenda where ID_User = (select ID from User where Username = :username) and Notes = :notes")
    Optional<DataTransferObject> checkPageRepo(String username, String notes);

    @Query("select Notes from Agenda where ID_User = (select ID from User where Username = :username)")
    List<String> showNotesRepo(String username);
}
