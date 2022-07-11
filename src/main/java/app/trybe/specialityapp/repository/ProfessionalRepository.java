package app.trybe.specialityapp.repository;

import app.trybe.specialityapp.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface.
 */
@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Integer> {

}
