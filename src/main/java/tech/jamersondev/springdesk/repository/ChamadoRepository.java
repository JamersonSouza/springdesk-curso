package tech.jamersondev.springdesk.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.jamersondev.springdesk.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

    @Query(value = "select * from chamado", nativeQuery = true)
    public Page<Chamado> findAllChamados(Pageable page);
    
}
