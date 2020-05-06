package cn.huangjin.service;

import cn.huangjin.dao.TextbookMapper;
import cn.huangjin.domain.Textbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextbookService {

    @Autowired
    private TextbookMapper textbookMapper;

    public List<Textbook> findAll() {
        return textbookMapper.selectByExample(null);
    }
}
