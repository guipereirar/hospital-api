package br.edu.senaisp.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.Hospital.model.Medico;

public interface HospitalRepository extends JpaRepository<Medico, Integer> {

}
