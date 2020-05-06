package cn.huangjin.controller;

import cn.huangjin.domain.Users;
import cn.huangjin.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询所有老师
     * @return
     */
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1") Integer page, @RequestParam(required = false,defaultValue = "5") Integer size){
        ModelAndView modelAndView = new ModelAndView();
        List<Users> userList = userService.findAll(page,size);
        PageInfo<Users> pageInfo = new PageInfo<>(userList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("/member-list.jsp");
        return modelAndView;
    }

    /**
     * 添加教师
     * @param users
     * @return
     */
    @RequestMapping("add")
    public String add(Users users){
        userService.add(users);
        return "redirect:../close.jsp";
    }

    /**
     * 删除老师
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:findAll";
    }

    /**
     * 根据姓名查询教师信息
     * @param
     * @return
     */
    @RequestMapping("findByName")
    public ModelAndView findByName(String name){
        ModelAndView modelAndView = new ModelAndView();
        List<Users> userList = userService.findByName(name);
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("/member-list-search.jsp");
        return modelAndView;
    }


}
