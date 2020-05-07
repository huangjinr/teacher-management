package cn.huangjin.service;

import cn.huangjin.dao.TextbookMapper;
import cn.huangjin.domain.Textbook;
import cn.huangjin.domain.TextbookExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class TextbookService {

    @Autowired
    private TextbookMapper textbookMapper;

    public List<Textbook> findAll() {
        return textbookMapper.selectByExample(null);
    }

    public List<Textbook> findByBookName(String name) {
        TextbookExample textbookExample = new TextbookExample();
        TextbookExample.Criteria criteria = textbookExample.createCriteria();
        criteria.andBooknameLike("%"+name+"%");
        return textbookMapper.selectByExample(textbookExample);
    }

    @Transactional
    public void add(Textbook textbook) {
        textbookMapper.insertSelective(textbook);
    }

    @Transactional
    public void delete(Integer id) {
        textbookMapper.deleteByPrimaryKey(id);
    }

    public Textbook findById(Integer id) {
        return textbookMapper.selectByPrimaryKey(id);
    }

    public void update(Textbook textbook) {
        textbookMapper.updateByPrimaryKey(textbook);
    }
}
