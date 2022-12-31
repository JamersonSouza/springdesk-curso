package tech.jamersondev.springdesk.Enums;

public enum StatusTicket {

    ABERTO("Aberto"),
    ANDAMENTO("Em Andamento"),
    FECHADO("Fechado");

    
    private String chamadoTicket;


    private StatusTicket(String chamadoTicket) {
        this.chamadoTicket = chamadoTicket;
    }

    public String getChamadoTicket() {
        return chamadoTicket;
    }

    public void setChamadoTicket(String chamadoTicket) {
        this.chamadoTicket = chamadoTicket;
    }

    

    
    
}
