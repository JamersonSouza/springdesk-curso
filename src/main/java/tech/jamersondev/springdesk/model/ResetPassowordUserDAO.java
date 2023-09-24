package tech.jamersondev.springdesk.model;

public class ResetPassowordUserDAO {

    private String senhaAtual;

    private String novaSenha;


    public ResetPassowordUserDAO(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }


    public ResetPassowordUserDAO() {
    }



    public String getSenhaAtual() {
        return senhaAtual;
    }

    public void setSenhaAtual(String senhaAtual) {
        this.senhaAtual = senhaAtual;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    
    
}
