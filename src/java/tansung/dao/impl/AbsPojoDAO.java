package tansung.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import tansung.dao.IPojoDAO;

/**
 * 抽象的数据库访问对象，泛型Pojo决定了该对象可访问的持久化实体的类型，
 * Key是对应的持久化实体的主键类型，功能实现基于Spring的HibernateDaoSupport。
 * 主要用作提供给具体DAO对象来继承，方法使用参见IPojoDAO接口。
 */
public abstract class AbsPojoDAO<Pojo, Key extends Serializable> extends HibernateDaoSupport implements IPojoDAO<Pojo, Key> {

    public AbsPojoDAO() {
    }

    public abstract String getEntityName(); // 定位实体的实体全名，包含包路径

    public abstract String getOrderField(); // 对实体进行列表访问时所用来排序的字段，多个字段请使用“,”隔开

    public abstract String getIdField(); // 实体主键字段的名字

    /**
     * 用来进行实体查询的实体名，不包含包路径
     */
    public String getShortEntityName() {
        String entityName = getEntityName();
        return entityName.substring(entityName.lastIndexOf('.') + 1);
    }

    public void save(Pojo obj) {
        this.getHibernateTemplate().save(obj);
    }

    public void save(Collection<Pojo> list) {
        this.getHibernateTemplate().saveOrUpdateAll(list);
    }

    public void update(Pojo obj) {
        this.getHibernateTemplate().update(obj);
    }

    public void saveOrUpdate(Pojo obj) {
        this.getHibernateTemplate().saveOrUpdate(obj);
    }

    public void delete(Pojo obj) {
        this.getHibernateTemplate().delete(obj);
    }

    public void deleteByKey(Key key) {
        Query query = this.createQuery("DELETE FROM "
                + this.getShortEntityName() + " AS a WHERE a."
                + this.getIdField() + "=:key");
        if (key instanceof BigDecimal) {
            query.setBigDecimal("key", (BigDecimal) key);
        } else if (key instanceof BigInteger) {
            query.setBigInteger("key", (BigInteger) key);
        } else if (key instanceof byte[]) {
            query.setBinary("key", (byte[]) key);
        } else if (key instanceof Boolean) {
            query.setBoolean("key", (Boolean) key);
        } else if (key instanceof Byte) {
            query.setByte("key", (Byte) key);
        } else if (key instanceof Calendar) {
            query.setCalendar("key", (Calendar) key);
        } else if (key instanceof Character) {
            query.setCharacter("key", (Character) key);
        } else if (key instanceof Date) {
            query.setDate("key", (Date) key);
        } else if (key instanceof Double) {
            query.setDouble("key", (Double) key);
        } else if (key instanceof Float) {
            query.setFloat("key", (Float) key);
        } else if (key instanceof Integer) {
            query.setInteger("key", (Integer) key);
        } else if (key instanceof Locale) {
            query.setLocale("key", (Locale) key);
        } else if (key instanceof Long) {
            query.setLong("key", (Long) key);
        } else if (key instanceof Short) {
            query.setShort("key", (Short) key);
        } else if (key instanceof String) {
            query.setText("key", (String) key);
        } else {
            query.setSerializable("key", key);
        }
        query.executeUpdate();
    }

    public void deleteAll() {
        this.createQuery("DELETE FROM " + this.getShortEntityName());
    }

    public boolean testKey(Key key) {
        return this.testField(this.getIdField(), key);
    }

    public boolean testField(String field, Key value) {
        Query query = this.createQuery("SELECT a." + field + " FROM "
                + this.getShortEntityName() + " AS a WHERE a." + field
                + "=:value");
        if (value instanceof BigDecimal) {
            query.setBigDecimal("value", (BigDecimal) value);
        } else if (value instanceof BigInteger) {
            query.setBigInteger("value", (BigInteger) value);
        } else if (value instanceof byte[]) {
            query.setBinary("value", (byte[]) value);
        } else if (value instanceof Boolean) {
            query.setBoolean("value", (Boolean) value);
        } else if (value instanceof Byte) {
            query.setByte("value", (Byte) value);
        } else if (value instanceof Calendar) {
            query.setCalendar("value", (Calendar) value);
        } else if (value instanceof Character) {
            query.setCharacter("value", (Character) value);
        } else if (value instanceof Date) {
            query.setDate("value", (Date) value);
        } else if (value instanceof Double) {
            query.setDouble("value", (Double) value);
        } else if (value instanceof Float) {
            query.setFloat("value", (Float) value);
        } else if (value instanceof Integer) {
            query.setInteger("value", (Integer) value);
        } else if (value instanceof Locale) {
            query.setLocale("value", (Locale) value);
        } else if (value instanceof Long) {
            query.setLong("value", (Long) value);
        } else if (value instanceof Short) {
            query.setShort("value", (Short) value);
        } else if (value instanceof String) {
            query.setText("value", (String) value);
        } else {
            query.setSerializable("value", value);
        }

        List<?> list = query.list();
        return list != null && list.size() != 0;
    }

    @SuppressWarnings("unchecked")
    public Pojo findByKey(Key key) {
        return (Pojo) this.getHibernateTemplate().get(this.getEntityName(), key);
    }

    public List<Pojo> listOrderBy(String field, boolean isDesc) {
        return this.listOrderBy(0, 0, field, isDesc);
    }

    @SuppressWarnings("unchecked")
    public List<Pojo> listOrderBy(int page, int size, String field,
            boolean isDesc) {
        Query query = this.createQuery("FROM " + this.getShortEntityName()
                + " ORDER BY " + field + (isDesc ? " DESC" : ""));
        if (page > 0 && size > 0) {
            return query.setFirstResult((page - 1) * size).setMaxResults(size).list();
        } else {
            return query.list();
        }
    }

    public List<Pojo> list() {
        return this.listOrderBy(this.getOrderField(), false);
    }

    public List<Pojo> list(int page, int size) {
        return this.listOrderBy(page, size, this.getOrderField(), false);
    }

    public List<Pojo> listDesc() {
        return this.listOrderBy(this.getOrderField(), true);
    }

    public List<Pojo> listDesc(int page, int size) {
        return this.listOrderBy(page, size, this.getOrderField(), true);
    }

    @SuppressWarnings("unchecked")
    public List<Pojo> listByExample(Pojo example) {
        return this.getHibernateTemplate().findByExample(example);
    }

    @SuppressWarnings("unchecked")
    public List<Pojo> listByExample(Pojo example, int page, int size) {
        return this.getHibernateTemplate().findByExample(example,
                (page - 1) * size, size);
    }

    public Query createQuery(String hql) {
        return this.getSession().createQuery(hql);
    }

    public List<Pojo> findByHQL(String hql) {
        return this.createQuery(hql).list();
    }

    public int getCount() {
        return Integer.parseInt(this.createQuery(
                "SELECT COUNT(*) FROM " + this.getShortEntityName()).list().get(0).toString());
    }

    public int getPageCount(int size) {
        return (int) Math.ceil((double) this.getCount() / (double) size);
    }
}
