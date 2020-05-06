package cn.huangjin.service;

import cn.huangjin.dao.ClassroomTeachingMapper;
import cn.huangjin.domain.ClassroomTeaching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private ClassroomTeachingMapper classroomTeachingMapper;

    public List<ClassroomTeaching> findAll() {
        return classroomTeachingMapper.selectByExample(null);
    }

    public void createEvaluate(Integer id, Integer source) {
        ClassroomTeaching classroomTeaching = new ClassroomTeaching();
        classroomTeaching.setId(id);
        classroomTeaching.setScore(source);
        classroomTeachingMapper.updateByPrimaryKeySelective(classroomTeaching);
    }
}
