package com.daspaket.diary.service;

import com.daspaket.diary.model.Agenda;
import com.daspaket.diary.model.DataTransferObject;
import com.daspaket.diary.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {
    //
    @Autowired
    AgendaRepository repo;

    @Override
    public List<Agenda> getAllNotes() {
        return repo.findAll();
    }

    public void addPage(String username, String notes)
    {
        //
        repo.addPageRepo(username, notes);
        /*if (list.isPresent())
        {
            //
            return list.get();
        }
        else
        {
            //
            return null;
        }*/
    }
    public DataTransferObject checkPage(String username, String notes)
    {
        //
        Optional<DataTransferObject> list = repo.checkPageRepo(username, notes);
        if (list.isPresent())
        {
            //
            return list.get();
        }
        else
        {
            //
            return null;
        }
    }
    public List<String> showNotes(String username)
    {
        //
        List<String> list = repo.showNotesRepo(username);
        if(!list.isEmpty())
        {
            return list;
        }
        else
        {
            return null;
        }
    }


}