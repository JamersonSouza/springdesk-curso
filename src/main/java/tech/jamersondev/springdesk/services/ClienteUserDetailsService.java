package tech.jamersondev.springdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.jamersondev.springdesk.model.Cliente;
import tech.jamersondev.springdesk.model.ClienteUserDetailsImpl;
import tech.jamersondev.springdesk.repository.ClienteRepository;

@Service
public class ClienteUserDetailsService implements UserDetailsService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(username)
        .orElseThrow( () -> new UsernameNotFoundException("Usuário não foi encontrado na base de dados"));
        return new ClienteUserDetailsImpl(cliente);
    }
    
}
