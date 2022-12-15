package ru.vsu.cs.nexnon;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.nexnon.database.db_temp;
import ru.vsu.cs.nexnon.entity.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMain() {
        return "information";
    }
    @GetMapping("/singup")
    public String singUp() {
        return "singup";
    }
    @GetMapping("/login")
    public String logIn() {
        return "login";
    }


    @PostMapping("/login")
    public @ResponseBody Map<String,String> loginPost(@RequestBody LogInPost entrant, Model model){
        Map<String, String> map = new HashMap<>();
        List<Entrant> list = db_temp.entrantList;
        for(Entrant e: list){
            if(e.equals(new Entrant("", entrant.getEmail(), entrant.getPassword(), 0))){
                map.put("token", e.getToken());
                break;
            }
        }
        if(map.isEmpty()){
            map.put("token", "null");
        }
        return map;
    }

    @PostMapping("/addapplication")
    public String addApplication(@RequestParam Map<String, Object> applicationPost, Model model){
        System.out.println(applicationPost);
        model.addAttribute("entrant", db_temp.getEntrant((String)applicationPost.get("entrant")));
        model.addAttribute("directions", db_temp.directionList);
        db_temp.applicationList.add(new Application(db_temp.getEntrant((String) applicationPost.get("entrant")), db_temp.getDirection(Integer.parseInt((String)applicationPost.get("direction")))));
        db_temp.applicationList.sort(new Comparator<Application>() {
            @Override
            public int compare(Application o1, Application o2) {
                if(o1.getDirection().getId() == o2.getDirection().getId()){
                    return o2.getEntrant().getScores() - o1.getEntrant().getScores();
                }else{
                    return o1.getDirection().getId() - o2.getDirection().getId();
                }

            }
        });
        return "user";
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String userPost(@RequestParam(name = "token", required = true) String token, Model model){
        System.out.println(token);
        if(token.equals("")){
            return "login";
        }else {
            model.addAttribute("entrant", db_temp.getEntrant(token));
            model.addAttribute("directions", db_temp.directionList);
            return "user";
        }
    }

    @PostMapping("/user/register")
    public @ResponseBody Map<String,String> register(@RequestParam Map<String, Object> entrant, Model model){
        Map<String, String> map = new HashMap<>();
        Entrant e = new Entrant(
                (String) entrant.get("name"),
                (String)entrant.get("email"),
                (String)entrant.get("password"),
                Integer.parseInt((String)entrant.get("score")));
        System.out.println((String)entrant.get("email"));
        map.put("token", e.getToken());
        db_temp.entrantList.add(e);
        return map;
    }

    @GetMapping("/registry")
    public String showRegistry(Model model) {
        model.addAttribute("registry", db_temp.applicationList);
        return "registry";
    }
}
