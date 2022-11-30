package ru.vsu.cs.nexnon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMain() {
        return "information";
    }
    @GetMapping("/account")
    public String showAccount() {
        return "personal_account";
    }
    @GetMapping("/registry")
    public String showRegistry() {
        return "registry";
    }
}
