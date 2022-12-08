package ru.vsu.cs.nexnon.essences;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Application> applications;

    public Registry(){
        applications = new ArrayList<>();
    }

    public void addApplication(Application application){
        applications.add(application);
    }

    public Application getApplication(int id){
        for(Application ap: applications){
            if(ap.getId() == id){
                return ap;
            }
        }
        return null;
    }
}
