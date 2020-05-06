package cn.huangjin.service;

import cn.huangjin.dao.UsersMapper;
import cn.huangjin.domain.Users;
import cn.huangjin.domain.UsersExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersMapper usersMapper;

    public Users findById(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }


    public List<Users> findAll(Integer page, Integer size) {
        //UsersExample usersExample = new UsersExample();
        PageHelper.startPage(page, size);
        return usersMapper.selectByExample(null);
    }

    @Transactional
    public void add(Users users) {
        usersMapper.insertSelective(users);
    }

    @Transactional
    public void delete(Integer id) {
        usersMapper.deleteByPrimaryKey(id);
    }

    public List<Users> findByName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameLike("%" + name + "%");
        return usersMapper.selectByExample(usersExample);
    }

    @Transactional
    public void update(Users users) {
        usersMapper.updateByPrimaryKey(users);
    }
}
