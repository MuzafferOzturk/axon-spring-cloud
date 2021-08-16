package com.example.demo.domain.command;

import lombok.Getter;

@Getter
public class CreateCommand extends BaseCommand<String> {
    private final double accountBalance;

    public CreateCommand(String id, double accountBalance) {
        super(id);
        this.accountBalance = accountBalance;
    }
}
