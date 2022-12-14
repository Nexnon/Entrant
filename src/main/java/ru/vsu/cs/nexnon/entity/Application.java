package ru.vsu.cs.nexnon.entity;

public class Application {

    private int id;
    private static int maxId = 0;

    private Entrant entrant;
    private Direction direction;

    public Application(Entrant entrant, Direction direction) {
        id = maxId++;
        this.entrant = entrant;
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
