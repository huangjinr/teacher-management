package cn.huangjin.controller;

import cn.huangjin.domain.ClassroomTeaching;
import cn.huangjin.domain.Thesis;
import cn.huangjin.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("thesis")
public class ThesisController {

    @Autowired
    private ThesisService thesisService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Thesis> thesisList = thesisService.findAll();
        modelAndView.addObject("thesisList",thesisList);
        modelAndView.setViewName("/thesis-list.jsp");
        return modelAndView;
    }
}
