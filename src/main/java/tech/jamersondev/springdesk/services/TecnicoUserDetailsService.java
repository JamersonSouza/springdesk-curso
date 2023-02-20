package tech.jamersondev.springdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.jamersondev.springdesk.model.Tecnico;
import tech.jamersondev.springdesk.model.TecnicoUserDetailsImpl;
import tech.jamersondev.springdesk.repository.TecnicoRepository;

@Service
public class TecnicoUserDetailsService implements UserDetailsService{

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Tecnico tecnico = tecnicoRepository.findByEmail(email)
        .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));
        return new TecnicoUserDetailsImpl(tecnico);
    }
    
}
