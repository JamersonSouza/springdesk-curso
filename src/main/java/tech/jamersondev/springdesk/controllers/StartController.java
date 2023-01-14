package tech.jamersondev.springdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.repository.ChamadoRepository;


@Controller
public class StartController {


    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("home")
    public ModelAndView start(){
        ModelAndView mv = new ModelAndView("home/index");
        mv.addObject("chamadosList", chamadoRepository.findAllChamados());
        return mv;
    }


}
