package cn.huangjin.controller;

import cn.huangjin.domain.Textbook;
import cn.huangjin.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("textbook")
public class TextbookController {

    @Autowired
    private TextbookService textbookService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Textbook> textbookList = textbookService.findAll();
        modelAndView.addObject("textbookList",textbookList);
        modelAndView.setViewName("/textbook-list.jsp");
        return modelAndView;
    }
}
