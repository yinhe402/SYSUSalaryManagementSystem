package tansung.dao;

import java.util.Collection;
import java.util.List;
import java.io.Serializable;
import org.hibernate.Query;

/**
 * 数据库访问对象的公共接口，泛型Pojo决定了该对象可访问的持久化实体的类型，
 * Key是对应的持久化实体的主键类型。
 */
public interface IPojoDAO<Pojo, Key extends Serializable> {

    /**
     * 保存一个实体
     */
    void save(Pojo obj);

    /**
     * 保存一个实体的集合，如果集合中的实体已存在于数据，执行更新操作
     */
    void save(Collection<Pojo> list);

    /**
     * 更新一个实体
     */
    void update(Pojo obj);

    /**
     * 保存或更新一个实体
     */
    void saveOrUpdate(Pojo obj);

    /**
     * 根据实体的主键值查找实体
     */
    Pojo findByKey(Key key);

    /**
     *删除一个实体
     */
    void delete(Pojo obj);

    /**
     *根据一个实体的主键值删除一个实体
     */
    void deleteByKey(Key key);

    /**
     * 删除该实体映射表的所有数据
     */
    void deleteAll();

    /**
     * 测试数据库中是否存在拥有该主键值的实体，有则返回true
     */
    boolean testKey(Key key);

    /**
     * 测试数据库中是否存在拥有该字段值的实体，有则返回true
     */
    boolean testField(String field, Key value);

    /**
     * 按指定字段进行排序，isDesc决定降序还是升序
     * 多个字段请使用“,”隔开（直接拼接到hql语句中）
     */
    List<Pojo> listOrderBy(String field, boolean isDesc);

    /**
     * 按指定字段进行排序，isDesc决定降序还是升序
     * 多个字段请使用“,”隔开（直接拼接到hql语句中）
     * 具有分页查询功能
     * @param page 从1开始
     * @return
     */
    List<Pojo> listOrderBy(int page, int size, String field, boolean isDesc);

    /**
     * 列出所有实体
     */
    List<Pojo> list();

    /**
     * 分页列出所有实体
     * @param page 从1开始
     */
    List<Pojo> list(int page, int size);

    /**
     * 倒序列出所有实体
     */
    List<Pojo> listDesc();

    /**
     * 倒序列出所有实体
     * @param page 从1开始
     */
    List<Pojo> listDesc(int page, int size);

    /**
     * 列出具有该实体样板的所有实体，详细见Hibernate的findByExample函数
     */
    List<Pojo> listByExample(Pojo example);

    /**
     * 列出具有该实体样板的所有实体，详细见Hibernate的findByExample函数。具有分页功能
     * @param page 从1开始
     */
    List<Pojo> listByExample(Pojo example, int page, int size);

    /**
     * 创建一个HQL对象进行查询
     * 不推荐使用，因为直接在bll层操作Query不合理
     */
    Query createQuery(String hql);

    /**
     * 根据hql查询获得实体列表
     */
    public List<Pojo> findByHQL(String hql);

    /**
     * 获取该实体在数据库中的个数
     */
    int getCount();

    /**
     * 获取该实体在指定的分页大小下在数据库的页数
     * @return
     */
    int getPageCount(int size);
}
