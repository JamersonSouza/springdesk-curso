package tech.jamersondev.springdesk.model;

import tech.jamersondev.springdesk.Enums.Perfil;

public abstract class Pessoa {

    
    private Integer id;
    private String nome;
    private String email; 
    private String senha;
    private String imagem;
    private Perfil perfil;

    public Pessoa(){}
    

    public Pessoa(Integer id, String nome, String email, String senha, String imagem, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.imagem = imagem;
        this.perfil = perfil;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public Perfil getPerfil() {
        return perfil;
    }
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    

    
}
