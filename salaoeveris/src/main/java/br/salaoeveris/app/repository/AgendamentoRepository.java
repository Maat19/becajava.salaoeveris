package br.salaoeveris.app.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import br.salaoeveris.app.model.Agendamento;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
	
//	@Query(value = "EXEC SP_Agendamento ':dataInicio', ':dataFim'", nativeQuery = true)
//	
//    List<RelAgendamento> findAgendamento(@Param("dataInicio") String dataInicio,@Param("dataFim") String dataFim);

}
