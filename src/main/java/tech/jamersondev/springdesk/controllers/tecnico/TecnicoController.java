package tech.jamersondev.springdesk.controllers.tecnico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Tecnico;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {

    @GetMapping("/cadastro")
    public ModelAndView cadastro(Tecnico tecnico){
        ModelAndView mv = new ModelAndView("tecnico/cadastro");
        mv.addObject("tecnico", tecnico);
        mv.addObject("perfils", Perfil.values());
        return mv;
    }
    
}
