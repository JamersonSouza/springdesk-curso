package tech.jamersondev.springdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.jamersondev.springdesk.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

    @Query(value = "select * from chamado", nativeQuery = true)
    public List<Chamado> findAllChamados();
    
}
