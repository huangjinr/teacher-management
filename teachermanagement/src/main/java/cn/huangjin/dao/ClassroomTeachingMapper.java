package cn.huangjin.dao;

import cn.huangjin.domain.ClassroomTeaching;
import cn.huangjin.domain.ClassroomTeachingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassroomTeachingMapper {
    int countByExample(ClassroomTeachingExample example);

    int deleteByExample(ClassroomTeachingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassroomTeaching record);

    int insertSelective(ClassroomTeaching record);

    List<ClassroomTeaching> selectByExample(ClassroomTeachingExample example);

    ClassroomTeaching selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassroomTeaching record, @Param("example") ClassroomTeachingExample example);

    int updateByExample(@Param("record") ClassroomTeaching record, @Param("example") ClassroomTeachingExample example);

    int updateByPrimaryKeySelective(ClassroomTeaching record);

    int updateByPrimaryKey(ClassroomTeaching record);
}