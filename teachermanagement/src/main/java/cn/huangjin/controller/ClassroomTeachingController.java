package cn.huangjin.controller;

import cn.huangjin.domain.ClassroomTeaching;
import cn.huangjin.service.ClassroomTeachingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("classroomTeaching")
public class ClassroomTeachingController {

    @Autowired
    private ClassroomTeachingService classroomTeachingService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<ClassroomTeaching> classroomTeachingList = classroomTeachingService.findAll();
        modelAndView.addObject("classroomTeachingList",classroomTeachingList);
        modelAndView.setViewName("/classroom-teaching-list.jsp");
        return modelAndView;
    }

    @RequestMapping("findByName")
    public ModelAndView findByName(String teacher){
        ModelAndView modelAndView = new ModelAndView();
        List<ClassroomTeaching> classroomTeachings = classroomTeachingService.findByName(teacher);
        modelAndView.addObject("classroomTeachingList",classroomTeachings);
        modelAndView.setViewName("/classroom-teaching-list.jsp");
        return modelAndView;
    }
}
