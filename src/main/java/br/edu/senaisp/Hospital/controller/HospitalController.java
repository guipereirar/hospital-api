package br.edu.senaisp.Hospital.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Hospital.model.Medico;
import br.edu.senaisp.Hospital.repository.HospitalRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class HospitalController {
	
	@Autowired
	HospitalRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Medico>> listar(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Medico>> busca(@PathVariable Integer id){
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@PostMapping()
	public @Valid Medico insere(@RequestBody @Valid Medico med) {
		return repository.save(med);
	}
	
	@PutMapping("/{id}")
	public @Valid ResponseEntity<Medico> alterar(@RequestBody @Valid Medico med, @PathVariable Integer id) {
		Optional<Medico> medicoData = repository.findById(id);
		
		if(medicoData.isPresent()) {
			Medico medico = medicoData.get();
			medico.setNome(med.getNome());
			medico.setCrm(med.getCrm());
			
			return new ResponseEntity<>(repository.save(medico), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Medico> excluir (@PathVariable Integer id) {
		try {
			Medico med = repository.findById(id).orElseThrow();
			repository.deleteById(id);
			return ResponseEntity.ok(med);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
}

