package tech.jamersondev.springdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.model.Chamado;
import tech.jamersondev.springdesk.repository.ChamadoRepository;


@Controller
public class StartController {


    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping()
    public ModelAndView start(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page - 1),  2);
        Page<Chamado> resultPage = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPage);
        return mv;
    }


}
