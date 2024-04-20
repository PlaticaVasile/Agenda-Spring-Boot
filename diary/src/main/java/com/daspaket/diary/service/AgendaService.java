package com.daspaket.diary.service;

import com.daspaket.diary.model.Agenda;
import com.daspaket.diary.model.DataTransferObject;

import java.util.List;
import java.util.Optional;

public interface AgendaService {
    //
    public List<Agenda> getAllNotes();
    public void addPage(String username, String notes);
    public DataTransferObject checkPage(String username, String notes);
    public List<String> showNotes(String username);

}