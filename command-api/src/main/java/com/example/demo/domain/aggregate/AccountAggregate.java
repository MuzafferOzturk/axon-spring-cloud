package com.example.demo.domain.aggregate;

import com.example.demo.data.CreateEvent;
import com.example.demo.data.DepositeEvent;
import com.example.demo.domain.command.CreateCommand;
import com.example.demo.domain.command.DepositeCommand;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@NoArgsConstructor
@Log4j2
public class AccountAggregate {
    @AggregateIdentifier
    private String id;
    private double balance;

    @CommandHandler
    public AccountAggregate(CreateCommand createCommand) {
        AggregateLifecycle.apply(new CreateEvent(createCommand.getId(), createCommand.getAccountBalance()));
    }

    @EventSourcingHandler
    public void on(CreateEvent createEvent) {
        log.debug("Create event {} ", createEvent);
        this.id = createEvent.getId();
        this.balance = createEvent.getBalance();
    }

    @CommandHandler
    public void handle(DepositeCommand depositeCommand) {
        AggregateLifecycle.apply(new DepositeEvent(depositeCommand.getId(), depositeCommand.getAccountBalance()));
    }

    @EventSourcingHandler
    public void on(DepositeEvent depositeEvent) {
        log.debug("Deposite event {} ", depositeEvent);
        this.balance += depositeEvent.getBalance();
    }
}

