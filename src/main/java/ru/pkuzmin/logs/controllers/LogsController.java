package ru.pkuzmin.logs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pkuzmin.logs.entities.MessageEntity;
import ru.pkuzmin.logs.services.LogsService;


import java.util.List;

@RestController
public class LogsController {
    private final LogsService logsService;


    @Autowired
    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }

    @PostMapping(value = "/log")
    public ResponseEntity<MessageEntity> save(@RequestBody MessageEntity requestContent) {
            MessageEntity message;
        try {
            message = new MessageEntity();
            message.setMessage(requestContent.getMessage());
            message.setLevel(requestContent.getLevel());
            message.setType(requestContent.getType());
            message.setTime(requestContent.getTime());
            logsService.save(message);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping(value = "/log")
    public ResponseEntity<List<MessageEntity>> getLog() {
        final List<MessageEntity> log;
        try {
            log = logsService.getAll();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(log, HttpStatus.OK);
    }
}
