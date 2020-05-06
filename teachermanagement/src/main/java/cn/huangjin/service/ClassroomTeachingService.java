package cn.huangjin.service;

import cn.huangjin.dao.ClassroomTeachingMapper;
import cn.huangjin.domain.ClassroomTeaching;
import cn.huangjin.domain.ClassroomTeachingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomTeachingService {

    @Autowired
    private ClassroomTeachingMapper classroomTeachingMapper;

    public List<ClassroomTeaching> findAll() {
        return classroomTeachingMapper.selectByExample(null);
    }


    public List<ClassroomTeaching> findByName(String teacher) {
        ClassroomTeachingExample classroomTeachingExample = new ClassroomTeachingExample();
        ClassroomTeachingExample.Criteria criteria = classroomTeachingExample.createCriteria();
        criteria.andTeacherLike("%" + teacher + "%");
        return classroomTeachingMapper.selectByExample(classroomTeachingExample);
    }
}
