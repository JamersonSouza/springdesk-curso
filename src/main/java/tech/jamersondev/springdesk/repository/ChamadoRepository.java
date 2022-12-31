package tech.jamersondev.springdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.jamersondev.springdesk.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
    
}
