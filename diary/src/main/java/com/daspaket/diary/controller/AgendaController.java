package com.daspaket.diary.controller;

import com.daspaket.diary.model.Agenda;
import com.daspaket.diary.model.DataTransferObject;
import com.daspaket.diary.model.Stringulescu;
import com.daspaket.diary.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/agenda")
public class AgendaController
{
    @Autowired
    AgendaService service;
    @GetMapping(path = "/all")
    public List<Agenda> showAll()
    {
        return service.getAllNotes();
    }
    @PutMapping(path = "/add-note")
    public void insertPage(@RequestBody DataTransferObject obj)
    {
        service.addPage(obj.getUsername(), obj.getNotes());
        /*
        if(service.checkPage(obj.getUsername(), obj.getNotes())!=null)
        {
            return "Note added successfully!";
        }
        else
        {
            return "Note wasn't added.";
        }
        */
    }
    @PostMapping(path = "/notes")
    public List<String> showNotesController(@RequestBody Stringulescu username)
    {
        return service.showNotes(username.getUsername());
    }

}
