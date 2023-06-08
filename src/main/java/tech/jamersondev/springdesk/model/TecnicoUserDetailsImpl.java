package tech.jamersondev.springdesk.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import tech.jamersondev.springdesk.Enums.Perfil;


public class TecnicoUserDetailsImpl implements UserDetails{

    private Tecnico tecnico;

    public TecnicoUserDetailsImpl(Tecnico tecnico){
        this.tecnico = tecnico;
    }

    public Integer getId(){
        return tecnico.getId();
    }

    public String getNome(){
        return tecnico.getNome();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Perfil perfil = tecnico.getPerfil();
        if(perfil == Perfil.ADMIN){
            perfil = Perfil.ADMIN;
        }else{
            perfil = Perfil.TECNICO;
        }
        return AuthorityUtils.createAuthorityList(perfil.toString());
    }

    @Override
    public String getPassword() {
        return tecnico.getSenha();
    }

    @Override
    public String getUsername() {
        return tecnico.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}