package sg.edu.nus.iss.demoDay1a.service;

import java.util.*;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.demoDay1a.model.Person;

@Service
public class PersonService {
    private List<Person> persons = new ArrayList<Person>();

    public PersonService(){
        //firstName, lastName should let it auto generate
        persons.add(new Person("Mark", "Kwan"));
        persons.add(new Person("Daryl", "Eddie"));

    }

    public List<Person> getPersons() {
        return this.persons;
    }

    //Create
    public void addPerson(Person newPerson) {
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    //Delete
    public void removePerson(Person personToDelete) {
        //when you have a list of objects, this is a faster way. p represents a person (list of person record) find any will return person record, or else set personToDelete as null
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    //Update
    public void updatePerson(Person personToUpdate) {
        Person foundPerson = persons.stream().filter(p -> p.getId().equals(personToUpdate.getId())).findAny().orElse(null);
        Person updatePerson = new Person();
        updatePerson.setId(personToUpdate.getId());
        updatePerson.setFirstName(personToUpdate.getFirstName());
        updatePerson.setLastName(personToUpdate.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);
    }
}
