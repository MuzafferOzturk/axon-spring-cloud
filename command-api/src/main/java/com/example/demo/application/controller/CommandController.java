package com.example.demo.application.controller;

import com.example.demo.data.DepositeEvent;
import com.example.demo.domain.command.CreateCommand;
import com.example.demo.domain.command.DepositeCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/command")
@RequiredArgsConstructor
public class CommandController {
    private final CommandGateway commandGateway;
    @PostMapping("/create")
    public ResponseEntity create(@RequestParam("userId") String userId, @RequestParam("balance") double balance) {
        commandGateway.sendAndWait(new CreateCommand(userId, balance));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/deposite")
    public ResponseEntity deposite(@RequestParam("userId") String userId, @RequestParam("balance") double balance) {
        commandGateway.sendAndWait(new DepositeCommand(userId, balance));
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
