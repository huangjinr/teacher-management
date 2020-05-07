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

    @RequestMapping("findByBookName")
    public ModelAndView findByBookName(String bookName){
        ModelAndView modelAndView = new ModelAndView();
        List<Textbook> textbookList = textbookService.findByBookName(bookName);
        modelAndView.addObject("textbookList",textbookList);
        modelAndView.setViewName("/textbook-list-search.jsp");
        return modelAndView;
    }

    @RequestMapping("add")
    public String add(Textbook textbook){
        textbookService.add(textbook);
        return "redirect:../close.jsp";
    }

    @RequestMapping("delete")
    public String delete(Integer id){
        textbookService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("echo")
    public ModelAndView echo(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Textbook textbook = textbookService.findById(id);
        modelAndView.addObject("textbook",textbook);
        modelAndView.setViewName("/textbook-edit.jsp");
        return modelAndView;
    }

    @RequestMapping("update")
    public String update(Textbook textbook){
        textbookService.update(textbook);
        return "redirect:../close.jsp";
    }
}
