package tech.jamersondev.springdesk.controllers.UsuarioControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserCotnroller {


    @GetMapping("/login")
    public String login(){
        return "login/login";
    }    
}
