package br.com.doctorfeet.controleretorno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.doctorfeet.controleretorno.entity.Contato;

public interface ContatoRepository extends CrudRepository<Contato, Long>{

	@Query(value = "SELECT co.* FROM contato co left join cliente cli on cli.id = co.cliente_id where co.dh_contato < (now() - interval 30 day) and co.feedback_id in (3,4,5);", nativeQuery=true)
	List<Contato> findContatos();
	
}
