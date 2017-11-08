package br.com.doctorfeet.controleretorno.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.doctorfeet.controleretorno.entity.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{

}
