package tech.jamersondev.springdesk.controllers.tecnico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Chamado;
import tech.jamersondev.springdesk.model.Tecnico;
import tech.jamersondev.springdesk.repository.ChamadoRepository;
import tech.jamersondev.springdesk.repository.TecnicoRepository;
import tech.jamersondev.springdesk.util.PasswordUtil;
import tech.jamersondev.springdesk.util.UploadUtil;

@Controller
@RequestMapping("/tecnico")
public class TecnicoController {
    
    @Autowired
    private TecnicoRepository tecRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/cadastro")
    public ModelAndView cadastro(Tecnico tecnico){
        ModelAndView mv = new ModelAndView("tecnico/cadastro");
        mv.addObject("tecnico", tecnico);
        Perfil[] profiles = {Perfil.ADMIN, Perfil.TECNICO};
        mv.addObject("perfils", profiles);
        return mv;
    }

    @PostMapping("/cadastro-tecnico")
    public ModelAndView cadastro(@ModelAttribute Tecnico tecnico, @RequestParam("file") MultipartFile imagem){
       ModelAndView mv =  new ModelAndView("tecnico/cadastro");
       String hashSenha = PasswordUtil.encoder(tecnico.getSenha());
       tecnico.setSenha(hashSenha);
       mv.addObject("tecnico", tecnico);

       try {
        if(UploadUtil.fazerUploadImagem(imagem)){
            tecnico.setImagem(imagem.getOriginalFilename());
        }
        tecRepository.save(tecnico);
        System.out.println("Salvo com sucesso: " + tecnico.getNome() + " " + tecnico.getImagem());
        return home(1);
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
    public ModelAndView home(@RequestParam(defaultValue = "1") int page){
        ModelAndView mv =  new ModelAndView("home/index");
         Pageable pageReq = PageRequest.of((page - 1),  2);
        Page<Chamado> resultPage = chamadoRepository.findAll(pageReq);
        mv.addObject("chamadosList", resultPage);
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id){
        ModelAndView mv =  new ModelAndView("tecnico/editar");
        mv.addObject("perfils", Perfil.values());
        mv.addObject("tec", tecRepository.findById(id));
        return mv;
    }

    @PostMapping("/editar-tecnico")
    public ModelAndView editar(Tecnico tecnico){
        ModelAndView mv =  new ModelAndView("tecnico/editar");
        tecRepository.save(tecnico);
        return tecnicosList();
    }

}
