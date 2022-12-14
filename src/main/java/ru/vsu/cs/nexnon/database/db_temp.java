package ru.vsu.cs.nexnon.database;

import ru.vsu.cs.nexnon.entity.Application;
import ru.vsu.cs.nexnon.entity.Direction;
import ru.vsu.cs.nexnon.entity.Entrant;

import java.util.ArrayList;
import java.util.List;

public class db_temp {
    public static List<Entrant> entrantList = new ArrayList<>();
    public static List<Application> applicationList = new ArrayList<>();
    public static List<Direction> directionList = new ArrayList<>();

    public static Entrant getEntrant(String token){
        for (Entrant e: entrantList){
            if(e.getToken().equals(token)){
                return e;
            }
        }
        throw new RuntimeException("Incorrect token");
    }
}
