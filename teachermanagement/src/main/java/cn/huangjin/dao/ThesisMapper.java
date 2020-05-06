package cn.huangjin.dao;

import cn.huangjin.domain.Thesis;
import cn.huangjin.domain.ThesisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThesisMapper {
    int countByExample(ThesisExample example);

    int deleteByExample(ThesisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Thesis record);

    int insertSelective(Thesis record);

    List<Thesis> selectByExample(ThesisExample example);

    Thesis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Thesis record, @Param("example") ThesisExample example);

    int updateByExample(@Param("record") Thesis record, @Param("example") ThesisExample example);

    int updateByPrimaryKeySelective(Thesis record);

    int updateByPrimaryKey(Thesis record);
}