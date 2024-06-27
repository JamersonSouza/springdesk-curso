package tech.jamersondev.springdesk.controllers.chamados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.Enums.Prioridade;
import tech.jamersondev.springdesk.Enums.StatusTicket;
import tech.jamersondev.springdesk.model.Chamado;
import tech.jamersondev.springdesk.repository.ChamadoRepository;
import tech.jamersondev.springdesk.repository.TecnicoRepository;
import tech.jamersondev.springdesk.services.ChamadoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ticket")
public class Chamados {

    private final TecnicoRepository tecnicoRepository;
    
    private final ChamadoRepository chamadoRepository;
    private final ChamadoService ticketService;

    public Chamados(TecnicoRepository tecnicoRepository, ChamadoRepository chamadoRepository, ChamadoService ticketService) {
        this.tecnicoRepository = tecnicoRepository;
        this.chamadoRepository = chamadoRepository;
        this.ticketService = ticketService;
    }

    @GetMapping
    public ModelAndView chamadoHome(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page - 1),  2);
        Page<Chamado> resultPage = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPage);
        return mv;
    }


    @GetMapping("/criar")
    public ModelAndView ticket(Chamado chamado){
        ModelAndView mv = new ModelAndView("chamados/ticket");
        mv.addObject("statusChamados", StatusTicket.values());
        mv.addObject("Prioridade", Prioridade.values());
        mv.addObject("tecnicos", tecnicoRepository.findAll());
        mv.addObject("tickets", chamado);
        return mv;
    }

    @PostMapping("/new-ticket")
    public ModelAndView newticket(Chamado chamado){
        chamadoRepository.save(chamado);
        return chamadoHome(1);
    }

    @GetMapping("/export")
    public void exportCsv(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio.csv");
        this.ticketService.exportCsv(response.getWriter());
    }

}
