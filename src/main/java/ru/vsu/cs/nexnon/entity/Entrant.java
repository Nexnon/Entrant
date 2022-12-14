package ru.vsu.cs.nexnon.entity;

import java.awt.*;
import java.util.Objects;

public class Entrant {

    private final String token;
    private static int maxId = 0;

    private String email;

    private String name;

    private String password;

    private Image passportScan;

    private Image scanOfCertificate;

    private int scores;

    private Image photo;

    public Entrant(String email, String password, Image passportScan, Image scanOfCertificate, int scores, Image photo) {
        token = name + maxId++;
        this.email = email;
        this.password = password;
        this.passportScan = passportScan;
        this.scanOfCertificate = scanOfCertificate;
        this.scores = scores;
        this.photo = photo;
    }

    public Entrant(String name, String email, String password) {
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

    public Entrant(String name){
        this.name = name;
        char[] letters = name.toCharArray();
        StringBuilder str = new StringBuilder();
        for(char c: letters){
            str.append((char)(c+5+(maxId % 4)));
        }
        for(char c: letters){
            str.append((char)(c+5+ (maxId % 3)));
        }
        maxId++;
        token = str.toString();
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

    public Image getPassportScan() {
        return passportScan;
    }

    public void setPassportScan(Image passportScan) {
        this.passportScan = passportScan;
    }

    public Image getScanOfCertificate() {
        return scanOfCertificate;
    }

    public void setScanOfCertificate(Image scanOfCertificate) {
        this.scanOfCertificate = scanOfCertificate;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }
}
