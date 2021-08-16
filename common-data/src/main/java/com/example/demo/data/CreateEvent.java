package com.example.demo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateEvent extends BaseEvent<String> {

    private double balance;

    public CreateEvent(String id, double balance) {
        super(id);
        this.balance = balance;
    }
}
