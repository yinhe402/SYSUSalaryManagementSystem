package tansung.dao.impl;

import tansung.dao.IPersonDAO;
import tansung.model.Person;

public class PersonDAO extends AbsPojoDAO<Person, Integer> implements IPersonDAO {
  
  public String getEntityName() {
    return Person.class.getName();
  }

  //覆盖父类的这个方法，详细见父类的实现。返回的string用于hql查询的时候排序，order by XXX
  public String getOrderField() {
    return "id";
  }

  //注明Model类中哪个字段是id
  public String getIdField() {
    return "id";
  }
}
