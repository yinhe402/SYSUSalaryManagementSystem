package tansung.service.impl;

import java.util.List;
import tansung.dao.IPersonDAO;
import tansung.model.Person;
import tansung.service.IPersonService;

public class PersonService implements IPersonService {

    private IPersonDAO personDAO;

    public IPersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(IPersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void addPerson(Person person) {
        personDAO.save(person);
    }

    public void deletePerson(int id) {
        personDAO.deleteByKey(id);
    }

    public List<Person> listAllPersons() {
//		return personDAO.list();
        return personDAO.findByHQL("from Person");         //使用hql查询的例子
    }

    public void updatePerson(int id, String newName) {
        Person person = personDAO.findByKey(id);
        person.setName(newName);
        personDAO.update(person);
    }
}
