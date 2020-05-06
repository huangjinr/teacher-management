package cn.huangjin.dao;

import cn.huangjin.domain.Textbook;
import cn.huangjin.domain.TextbookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TextbookMapper {
    int countByExample(TextbookExample example);

    int deleteByExample(TextbookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Textbook record);

    int insertSelective(Textbook record);

    List<Textbook> selectByExample(TextbookExample example);

    Textbook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Textbook record, @Param("example") TextbookExample example);

    int updateByExample(@Param("record") Textbook record, @Param("example") TextbookExample example);

    int updateByPrimaryKeySelective(Textbook record);

    int updateByPrimaryKey(Textbook record);
}