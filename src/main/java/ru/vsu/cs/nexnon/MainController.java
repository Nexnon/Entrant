package ru.vsu.cs.nexnon;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.nexnon.database.db_temp;
import ru.vsu.cs.nexnon.entity.*;

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
            if(e.equals(new Entrant("", entrant.getEmail(), entrant.getPassword()))){
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
        return "user";
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String user(@RequestParam(name = "token", required = false) String token, Model model){
        if(token.equals("null")){
            return "login";
        }else {
            model.addAttribute("entrant", db_temp.getEntrant(token));
            model.addAttribute("directions", db_temp.directionList);
            return "user";
        }
    }

    @PostMapping("/user/register")
    public @ResponseBody Map<String,String> register(@RequestBody EntrantPost entrant, Model model){
        Map<String, String> map = new HashMap<>();
        Entrant e = new Entrant(entrant.getName(), entrant.getEmail(), entrant.getPassword());
        System.out.println(entrant.getEmail());
        System.out.println(entrant.getName());
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
