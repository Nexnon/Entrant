package ru.vsu.cs.nexnon;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.nexnon.database.db_temp;
import ru.vsu.cs.nexnon.entity.Entrant;
import ru.vsu.cs.nexnon.entity.EntrantPost;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMain() {
        return "information";
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String user(@RequestParam(name = "token", required = false) String token, Model model){
        if(token == null){
            return "singup";
        }
        System.out.println(token);
        if(!token.equals("null")) {
            model.addAttribute("entrant", db_temp.getEntrant(token));
            return "user";
        }
        return "singup";
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
    public String showRegistry() {
        return "registry";
    }
}
