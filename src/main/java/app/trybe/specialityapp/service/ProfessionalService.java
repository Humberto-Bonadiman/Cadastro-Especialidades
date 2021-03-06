package app.trybe.specialityapp.service;

import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.repository.ProfessionalRepository;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {

  @Autowired
  private ProfessionalRepository repository;

  public Professional addProfessional(Professional professional) {
    return repository.save(professional);
  }

  public List<Professional> professionalList() {
    return repository.findAll();
  }

  /**
   * update professional by id.
   */
  public Professional updateProfessional(Professional professional, Integer id) {
    Professional getProfessional = repository.findById(id).get();
    getProfessional.setName(professional.getName());
    getProfessional.setSpeciality(professional.getSpeciality());
    return repository.save(getProfessional);
  }

  /**
   * delete professional.
   */
  public void deleteProfessionalById(Integer id) {
    Professional professional =
        repository.findById(id).orElseThrow(() -> new NoSuchElementException());
    repository.deleteById(professional.getId());
  }
}
