package tech.jamersondev.springdesk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("recursos")
public class PagesController {
    

    @GetMapping("404")
    public ModelAndView error404(){
        ModelAndView mv = new ModelAndView("pagesTema/erros/error-404");
        
        return mv;
    }

    @GetMapping("500")
    public ModelAndView error405(){
        ModelAndView mv = new ModelAndView("pagesTema/erros/error-500");
        return mv;
    }

    @GetMapping("elementos")
    public ModelAndView basicElements(){
        ModelAndView mv = new ModelAndView("pagesTema/forms/basic_elements");
        return mv;
    }

    @GetMapping("buttons")
    public ModelAndView btns(){
        ModelAndView mv = new ModelAndView("pagesTema/forms/buttons");
        return mv;
    }

    @GetMapping("icons")
    public ModelAndView icons(){
        ModelAndView mv = new ModelAndView("pagesTema/icons/icon");
        return mv;
    }
  
}
