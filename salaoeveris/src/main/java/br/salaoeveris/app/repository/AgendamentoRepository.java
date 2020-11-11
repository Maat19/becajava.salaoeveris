package br.salaoeveris.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.model.RelAgendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
	
	@Query(value = "EXEC SP_Agendamento ':dataInicio', ':dataFim'", nativeQuery = true)
	
    List<RelAgendamento> findAgendamento(@Param("dataInicio") String dataInicio,@Param("dataFim") String dataFim);

}
