package tech.jamersondev.springdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.jamersondev.springdesk.Enums.Perfil;
import tech.jamersondev.springdesk.model.Cliente;
import tech.jamersondev.springdesk.model.Tecnico;
import tech.jamersondev.springdesk.repository.ClienteRepository;
import tech.jamersondev.springdesk.repository.TecnicoRepository;
import tech.jamersondev.springdesk.util.PasswordUtil;

@Service
public class InjectDB {


    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public void injectDB(){
        Tecnico tecnico1 = new Tecnico(null, "Jamerson", "jamerson@mail.com",
         PasswordUtil.encoder("123456789"), null, Perfil.TECNICO);

        Cliente cliente1 = new Cliente(null, "Tereza", "tereza@mail.com", PasswordUtil.encoder("123456789"),null, 
        Perfil.CLIENTE);

        clienteRepository.saveAll(Arrays.asList(cliente1));
         tecnicoRepository.saveAll(Arrays.asList(tecnico1));
    }

      public void injectDBTest(){
        Tecnico tecnico1 = new Tecnico(null, "JamersonTeste", "jamersontest@mail.com",
         PasswordUtil.encoder("123456789"), null, Perfil.TECNICO);

        Cliente cliente1 = new Cliente(null, "TerezaTeste", "terezatest@mail.com", PasswordUtil.encoder("123456789"),null, 
        Perfil.CLIENTE);

        clienteRepository.saveAll(Arrays.asList(cliente1));
         tecnicoRepository.saveAll(Arrays.asList(tecnico1));
    }
    
}
