package com.mohamedali.spring.demo.dao;

import com.mohamedali.spring.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


// you can either put repository or component annoation
@Repository("postgressDB")
public class PersonDatabaseService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int addPerson(Person person) {
        UUID id = UUID.randomUUID();
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPersons() {
        return List.of(new Person(UUID.randomUUID(), "FROM DATABASE SERVICEE"));

    }

    @Override
    public Optional<Person> selectPersonByID(UUID uuid) {
        // using streams and Optional object
        return DB.stream().filter(person -> person.getId().equals(uuid)).
                findFirst();
    }

    @Override
    public int deletePersonByID(UUID uuid) {
        Optional<Person> personMaybe  = selectPersonByID(uuid);
        if(personMaybe.isEmpty())
            return 0;
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID uuid, Person updatedPerson) {
        return selectPersonByID(uuid)
                .map(personToFind -> {
                    int indexOfPersonToUpdate = DB.indexOf(personToFind);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Person(uuid, updatedPerson.getName()) );
                        return 1;
                    }

                    return 0;
                })
                .orElse(0);
    }
}
