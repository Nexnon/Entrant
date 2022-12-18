package ru.vsu.cs.nexnon.entity;



import jakarta.persistence.*;
import ru.vsu.cs.nexnon.database.DAO;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="entrant")
public class Entrant {

    @Id
    private String token;
    private static int maxId = new DAO().findAllEntrants().size();

    private String email;

    private String name;

    private String password;

    private int scores;

    public Entrant(String name, String email, String password, int score) {
        this.scores = score;
        this.email = email;
        this.name = name;
        this.password = password;

        char[] letters = name.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c: letters){
            str.append((char)(c+1)).append(maxId*4+c);
        }
        maxId++;
        token = str.toString();
    }

    public Entrant(String token, String email, String name, String password, int score) {
        this.scores = score;
        this.email = email;
        this.name = name;
        this.password = password;
        this.token = token;
    }

    public Entrant() {

    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entrant entrant = (Entrant) o;
        return Objects.equals(email, entrant.email) && Objects.equals(password, entrant.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return token + '&' +
                email + '&' +
                name + '&' +
                password + '&' +
                scores;
    }
}
