package tech.jamersondev.springdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Tecnico;
import tech.jamersondev.springdesk.repository.TecnicoRepository;
import tech.jamersondev.springdesk.util.PasswordUtil;

@Service
public class InjectDB {


    @Autowired
    private TecnicoRepository tecnicoRepository;


    public void injectDB(){
        Tecnico tecnico1 = new Tecnico(null, "Jamerson", "jamerson@mail.com",
         PasswordUtil.encoder("123456789"), null, Perfil.TECNICO);

         tecnicoRepository.saveAll(Arrays.asList(tecnico1));
    }
    
}
