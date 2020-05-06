package cn.huangjin.controller;

import cn.huangjin.domain.ClassroomTeaching;
import cn.huangjin.service.EvaluationService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @RequestMapping("findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<ClassroomTeaching> classroomTeachingList = evaluationService.findAll();
        modelAndView.addObject("classroomTeachingList", classroomTeachingList);
        modelAndView.setViewName("/curriculum-evaluation.jsp");
        return modelAndView;
    }

    @ResponseBody
    //@RequestMapping(value = "/createEvaluate",produces = "application/json; charset=utf-8")
    @RequestMapping("createEvaluate")
    public String createEvaluate(Integer id, Integer value) throws UnsupportedEncodingException {
        evaluationService.createEvaluate(id,value);
        return "true";
    }
}
