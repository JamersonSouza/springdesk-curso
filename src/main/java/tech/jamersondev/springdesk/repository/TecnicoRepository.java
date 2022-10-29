package tech.jamersondev.springdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.jamersondev.springdesk.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
    
}
