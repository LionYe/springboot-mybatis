package club.lionye.dao;

import club.lionye.entity.BloodItem;

public interface BloodItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(BloodItem record);

    int insertSelective(BloodItem record);

    BloodItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BloodItem record);

    int updateByPrimaryKey(BloodItem record);
}