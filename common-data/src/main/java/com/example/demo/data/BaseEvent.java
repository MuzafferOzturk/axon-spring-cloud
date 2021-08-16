package com.example.demo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BaseEvent<T> implements Serializable {
    private T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
