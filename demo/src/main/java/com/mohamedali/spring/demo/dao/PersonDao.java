package com.mohamedali.spring.demo.dao;

import com.mohamedali.spring.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int addPerson(Person person);

    List<Person> selectAllPersons();

    Optional<Person> selectPersonByID(UUID uuid);

    int deletePersonByID(UUID uuid);

    int updatePersonById(UUID uuid , Person person);

}
