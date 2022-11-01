package tech.jamersondev.springdesk.controllers.tecnico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Tecnico;
import tech.jamersondev.springdesk.repository.TecnicoRepository;
import tech.jamersondev.springdesk.util.UploadUtil;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {
    
    @Autowired
    private TecnicoRepository tecRepository;


    @GetMapping("/cadastro")
    public ModelAndView cadastro(Tecnico tecnico){
        ModelAndView mv = new ModelAndView("tecnico/cadastro");
        mv.addObject("tecnico", tecnico);
        mv.addObject("perfils", Perfil.values());
        return mv;
    }

    @PostMapping("/cadastro-tecnico")
    public ModelAndView cadastro(@ModelAttribute Tecnico tecnico, @RequestParam("file") MultipartFile imagem){
       ModelAndView mv =  new ModelAndView("tecnico/cadastro");
       mv.addObject("tecnico", tecnico);

       try {
        if(UploadUtil.fazerUploadImagem(imagem)){
            tecnico.setImagem(imagem.getOriginalFilename());
        }
        tecRepository.save(tecnico);
        System.out.println("Salvo com sucesso: " + tecnico.getNome() + " " + tecnico.getImagem());
        return home();
       } catch (Exception e) {
            mv.addObject("msgErro", e.getMessage());
            System.out.println("Erro ao salvar " + e.getMessage());
            return mv;
       }

    }


    @GetMapping("list-tecnicos")
    public ModelAndView tecnicosList(){
        ModelAndView mv = new ModelAndView("tecnico/tecnico-list");
        mv.addObject("tecnicos", tecRepository.findAll());
        return mv;
    }

    @GetMapping("/home-tecnico")
    public ModelAndView home(){
        ModelAndView mv =  new ModelAndView("home/index");
        return mv;
    }

    
}
