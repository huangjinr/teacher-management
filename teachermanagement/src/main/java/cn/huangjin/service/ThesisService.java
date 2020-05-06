package cn.huangjin.service;

import cn.huangjin.dao.ThesisMapper;
import cn.huangjin.domain.Thesis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesisService {

    @Autowired
    private ThesisMapper thesisMapper;

    public List<Thesis> findAll() {
        return thesisMapper.selectByExample(null);
    }
}
