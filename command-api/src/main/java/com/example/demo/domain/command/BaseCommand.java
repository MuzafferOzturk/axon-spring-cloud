package com.example.demo.domain.command;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
public class BaseCommand<T> implements Serializable {
    @TargetAggregateIdentifier
    private final T id;

    public BaseCommand(T id) {
        this.id = id;
    }
}
