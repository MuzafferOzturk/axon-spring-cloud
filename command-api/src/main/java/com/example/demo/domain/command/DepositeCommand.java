package com.example.demo.domain.command;

import lombok.Getter;

@Getter
public class DepositeCommand extends BaseCommand<String> {
    private final double accountBalance;

    public DepositeCommand(String id, double accountBalance) {
        super(id);
        this.accountBalance = accountBalance;
    }
}
