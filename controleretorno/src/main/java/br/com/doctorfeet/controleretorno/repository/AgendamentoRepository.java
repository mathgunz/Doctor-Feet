package br.com.doctorfeet.controleretorno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.doctorfeet.controleretorno.entity.Agendamento;

public interface AgendamentoRepository extends CrudRepository<Agendamento, Long>{
	
	@Query(value = "SELECT age.* FROM agendamento age JOIN contato co on co.id = age.contato_id where dh_agendamento < (now() - interval 30 day) and co.feedback_id = 1;", nativeQuery = true)
	List<Agendamento> findAgendamentosAvailable();

}
