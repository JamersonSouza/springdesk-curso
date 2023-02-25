package tech.jamersondev.springdesk.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import tech.jamersondev.springdesk.Enums.Perfil;



@Entity
public class Tecnico extends Pessoa{

    
    
    public Tecnico(Integer id, String nome, String email, String senha, String imagem, Perfil perfil) {
        super(id, nome, email, senha, imagem, perfil);
    }

    public Tecnico(){

    }

    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }

    

}
