package com.mohamedali.spring.demo.api;

import com.mohamedali.spring.demo.model.Person;
import com.mohamedali.spring.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:3002" , maxAge = 1000000)
@RequestMapping("/api")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID uuid){
        return personService.findPersonById(uuid).orElse(null);
    }

    @DeleteMapping(path = "{uuid}")
    public void deletePersonById(@PathVariable("uuid") UUID uuid){
        personService.deletePerson(uuid);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@Valid @NotNull @PathVariable("id") UUID id , @RequestBody Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}
