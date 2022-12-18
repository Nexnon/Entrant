package ru.vsu.cs.nexnon.entity;

import jakarta.persistence.*;
import ru.vsu.cs.nexnon.database.DAO;

import java.util.Collections;
import java.util.Comparator;


@Entity
@Table(name="direction")
public class Direction {

    @Id
    private int id;
    private static int maxId = new DAO().findAllDirections().size();

    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private int count;

    public Direction(String name, int count) {
        this.name = name;
        this.count = count;
        id = maxId++;

    }

    public Direction() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
