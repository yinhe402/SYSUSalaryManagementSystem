package tansung.service;

import java.util.List;

import tansung.model.Person;

public interface IPersonService {

	public  void addPerson(Person person);

	public  void deletePerson(int id);

	public  List<Person> listAllPersons();

	public  void updatePerson(int id, String newName);

}