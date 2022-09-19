package tech.jamersondev.springdesk.Enums;

public enum Perfil {

    ADMIN("Administrador"),
    TECNICO("Tecnico"),
    CLIENTE("Cliente");

    private String perfil;

    private Perfil(String perfil){
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    
    
}
