package ru.vsu.cs.nexnon.entity;


import jakarta.persistence.*;
import ru.vsu.cs.nexnon.database.DAO;

import java.util.Comparator;

@Entity
@Table(name = "application")
public class Application {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "token")
    private Entrant entrant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directionid")
    private Direction direction;

    @Id
    private int id;

    private static int maxId = new DAO().findAllApplications().size();

    public Application() {
    }

    public Application(Entrant entrant, Direction direction) {
        this.entrant = entrant;
        this.direction = direction;
        id = maxId++;
    }

    public Entrant getEntrant() {
        return entrant;
    }

    public void setEntrant(Entrant entrant) {
        this.entrant = entrant;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
