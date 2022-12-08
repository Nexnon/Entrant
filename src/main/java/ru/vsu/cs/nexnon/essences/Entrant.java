package ru.vsu.cs.nexnon.essences;

import java.awt.*;

public class Entrant {

    private int id;
    private static int maxId = 0;

    private String email;

    private String password;

    private Image passportScan;

    private Image scanOfCertificate;

    private int scores;

    private Image photo;

    public Entrant(String email, String password, Image passportScan, Image scanOfCertificate, int scores, Image photo) {
        id = maxId++;
        this.email = email;
        this.password = password;
        this.passportScan = passportScan;
        this.scanOfCertificate = scanOfCertificate;
        this.scores = scores;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
