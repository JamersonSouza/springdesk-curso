package tech.jamersondev.springdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StartController {

    @GetMapping("home")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView("home/index");
        return mv;
    }


}
