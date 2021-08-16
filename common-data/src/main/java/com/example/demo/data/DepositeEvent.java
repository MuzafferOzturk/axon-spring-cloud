package com.example.demo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DepositeEvent extends BaseEvent<String> {

    private double balance;

    public DepositeEvent(String id, double balance) {
        super(id);
        this.balance = balance;
    }
}
