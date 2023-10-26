package com.senai.erick.PrjGame.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.erick.PrjGame.Entities.Jogo;

import com.senai.erick.PrjGame.Repositories.JogoRepository;

@Service
public class JogoService {
	private final JogoRepository jogoRepository;

	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}

	public Jogo getJogoById(Long idJogo) {
		return jogoRepository.findById(idJogo).orElse(null);
	}

	public List<Jogo> getAllJogos() {
		return jogoRepository.findAll();
	}
	
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}

	public void deletejogo(Long idJogo) {
		jogoRepository.deleteById(idJogo);
	}
	
		public Jogo updateJogo(Long idJogo, Jogo novoJogo) {
			Optional<Jogo> jogoOptional = jogoRepository.findById(idJogo);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
}