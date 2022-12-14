package ru.vsu.cs.nexnon.entity;

import org.springframework.lang.NonNull;

public class tokenPost {
    @NonNull
    private String token;

    @NonNull
    public String getToken() {
        return token;
    }

    public void setToken(@NonNull String token) {
        this.token = token;
    }
}
