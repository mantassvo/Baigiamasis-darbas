package Vigi19.Baigiamasis_darbas.services;

import Vigi19.Baigiamasis_darbas.entities.RegistrationFormsOfPersons;
import Vigi19.Baigiamasis_darbas.repositories.RegistrationFormsOfPersonsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistrationFormsOfPersonsService {

    private RegistrationFormsOfPersonsRepository registrationFormsOfPersonsRepository;

    public void PersonRegistrationService(RegistrationFormsOfPersonsRepository registrationFormsOfPersonsRepository) {
        this.registrationFormsOfPersonsRepository = registrationFormsOfPersonsRepository;
    }

    public RegistrationFormsOfPersons getPersonById(Long id) {

        Optional<RegistrationFormsOfPersons> person = this.registrationFormsOfPersonsRepository.findById(id);
        if (person.isPresent()) {
            RegistrationFormsOfPersons registrationFormsOfPersons = person.get();
            return person.get();
        } else {
            return null;
        }
    }

    public void deletePersonById(Long id){
        this.registrationFormsOfPersonsRepository.deleteById(id);
    }

    public List<RegistrationFormsOfPersons> getAllPersons(){
        return this.registrationFormsOfPersonsRepository.findAll();
    }
    public void createPersons(RegistrationFormsOfPersons registrationFormsOfPersons ){
        this.registrationFormsOfPersonsRepository.save(registrationFormsOfPersons);
    }

    public void saveRegistrationFormsOfPersons(RegistrationFormsOfPersons newpersons) {
        this.registrationFormsOfPersonsRepository.save(newpersons);
    }
}
