package br.com.doctorfeet.controleretorno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctorfeet.controleretorno.entity.Feedback;
import br.com.doctorfeet.controleretorno.repository.FeedbackRepository;
import br.com.doctorfeet.controleretorno.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository repository;
	
	public List<Feedback> getFeedbacks(){
		return (List<Feedback>) this.repository.findAll();	
	}
	

}
