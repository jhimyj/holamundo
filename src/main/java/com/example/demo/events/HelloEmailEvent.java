package com.example.demo.events;

import lombok.Getter;

@Getter
public class HelloEmailEvent {
    private final String email;

    public HelloEmailEvent(String email) {
        super(email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
