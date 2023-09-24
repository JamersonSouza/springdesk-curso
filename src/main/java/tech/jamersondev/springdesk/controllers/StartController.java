package tech.jamersondev.springdesk.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Chamado;
import tech.jamersondev.springdesk.model.Cliente;
import tech.jamersondev.springdesk.model.ResetPassowordUserDAO;
import tech.jamersondev.springdesk.repository.ChamadoRepository;
import tech.jamersondev.springdesk.repository.ClienteRepository;
import tech.jamersondev.springdesk.util.PasswordUtil;


@Controller
public class StartController {


    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping()
    public ModelAndView start(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv = new ModelAndView("home/index");
        Pageable pageReq = PageRequest.of((page - 1),  2);
        Page<Chamado> resultPage = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPage);
        return mv;
    }

    @GetMapping("/redefinir-senha")
    public ModelAndView resetPassword(Principal principal){
        ModelAndView mv = new ModelAndView("home/resetPassword");
        Cliente clientAuth = this.clienteRepository.findByEmail(principal.getName()).get();
        ResetPassowordUserDAO currentSenhaDAO = new ResetPassowordUserDAO(clientAuth.getSenha());
        mv.addObject("senhaAtual", currentSenhaDAO);
        mv.addObject("resetPasswordUserDAO", new ResetPassowordUserDAO());
        return mv;
    }

    @PostMapping("/redefinir-senha")
    public String resetPassword(ResetPassowordUserDAO formularioUserDAO, Principal principal){
        Cliente clientAuth = this.clienteRepository.findByEmail(principal.getName()).get();
        if(PasswordUtil.matchersPassword(formularioUserDAO.getSenhaAtual(), clientAuth.getSenha())){
            clientAuth.setSenha(PasswordUtil.encoder(formularioUserDAO.getNovaSenha()));
            clientAuth.setPerfil(Perfil.CLIENTE);
            clienteRepository.save(clientAuth);
        }
        return "redirect:/";
    }


}
