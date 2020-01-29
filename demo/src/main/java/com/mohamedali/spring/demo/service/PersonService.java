package com.mohamedali.spring.demo.service;

import com.mohamedali.spring.demo.dao.PersonDao;
import com.mohamedali.spring.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {


    private final PersonDao personDao;

    // dependency injection
    // by changing qualifer you can decide which implemenation to use
    // aka dependency injection
    @Autowired
    public PersonService(@Qualifier("fakeDao")PersonDao personDao){
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        personDao.addPerson(person);
        return 0;
    }

    public List<Person> getAllPersons(){
        return personDao.selectAllPersons();
    }

    public Optional<Person> findPersonById(UUID uuid){
        return personDao.selectPersonByID(uuid);
    }

    public int deletePerson(UUID uuid){
        return personDao.deletePersonByID(uuid);
    }

    public int updatePerson(UUID uuid , Person person){
        return personDao.updatePersonById(uuid, person);
    }



}
