package ru.vsu.cs.nexnon.essences;

public class Direction {

    private int id;
    private static int maxId = 0;

    private String name;
    private int count;

    public Direction( String name, int count) {
        this.id = maxId++;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
