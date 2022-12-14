package ru.vsu.cs.nexnon.entity;

import org.springframework.lang.NonNull;

public class EntrantPost {
    @NonNull
    private String Name;

    @NonNull
    private String email;

    @NonNull
    private String password;

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
