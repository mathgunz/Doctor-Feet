package br.com.doctorfeet.controleretorno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.doctorfeet.controleretorno.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	@Query(value ="SELECT cli.* FROM cliente cli where not exists(select 1 from contato co where co.cliente_id = cli.id) and not exists(select 1 from agendamento age where age.cliente_id = cli.id)", nativeQuery = true)
	List<Cliente> findClientesAvailable();

}
