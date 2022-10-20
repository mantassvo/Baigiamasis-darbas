package Vigi19.Baigiamasis_darbas.controllers;

import Vigi19.Baigiamasis_darbas.dto.CreateRegistrationFormsOfPersonsRequestDTO;
import Vigi19.Baigiamasis_darbas.dto.GetRegistrationFormsOfPersonsResponseDTO;
import Vigi19.Baigiamasis_darbas.entities.RegistrationFormsOfPersons;
import Vigi19.Baigiamasis_darbas.services.RegistrationFormsOfPersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Vigi19.Baigiamasis_darbas.converter.RegistrationFormsOfPersonsConverter.*;
@CrossOrigin
@RestController
@RequestMapping("/RegistrationFormsOfPersons")
public class RegistrationFormsOfPersonsController {

    @Autowired
    private RegistrationFormsOfPersonsService registrationFormsOfPersonsService;

    @GetMapping()
    public List<RegistrationFormsOfPersons> getAllPersons() {
        return registrationFormsOfPersonsService.getAllPersons();
    }

    @PostMapping
    public void addRegistrationFormsOfPersons(@RequestBody CreateRegistrationFormsOfPersonsRequestDTO createRegistrationFormsOfPersonsRequestDTO) {
        RegistrationFormsOfPersons registrationFormsOfPersons = convertCreateRegistrationFormsOfPersonsRequestDtoToRegistrationFormsOfPersons(createRegistrationFormsOfPersonsRequestDTO);
        this.registrationFormsOfPersonsService.createPersons(registrationFormsOfPersons);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putPersonById(@PathVariable(name = "id") Long id, @RequestBody CreateRegistrationFormsOfPersonsRequestDTO requestDTO) {

        RegistrationFormsOfPersons person = this.registrationFormsOfPersonsService.getPersonById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        RegistrationFormsOfPersons newpersons = convertCreateRegistrationFormsOfPersonsRequestDtoToRegistrationFormsOfPersons(requestDTO);
        newpersons.setId(person.getId());
        this.registrationFormsOfPersonsService.saveRegistrationFormsOfPersons(newpersons);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchPersonById(@PathVariable(name = "id") Long id, @RequestBody CreateRegistrationFormsOfPersonsRequestDTO requestDTO) {

        RegistrationFormsOfPersons person = this.registrationFormsOfPersonsService.getPersonById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        patchRegistrationFormsOfPersonsFromCreateRegistrationFormsOfPersonsRequestDto(person, requestDTO);
        this.registrationFormsOfPersonsService.saveRegistrationFormsOfPersons(person);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<GetRegistrationFormsOfPersonsResponseDTO> getPersonById(@PathVariable(name = "id") Long id) {
        RegistrationFormsOfPersons person = this.registrationFormsOfPersonsService.getPersonById(id);
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(convertRegistrationFormsOfPersonsToGetRegistrationFormsOfPersonsResponseDto(person));
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonById(@PathVariable(name = "id") Long id) {
        this.registrationFormsOfPersonsService.deletePersonById(id);
            return ResponseEntity.ok().build();
        }



}
