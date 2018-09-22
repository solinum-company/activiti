package org.activiti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, String> {

	@Query("SELECT p FROM Priorite p WHERE LOWER(p.owner.matricule) = LOWER(:matricule)")
	public List<Priorite> getPrioritiesByMatricule(
			@Param("matricule") String matricule);
}