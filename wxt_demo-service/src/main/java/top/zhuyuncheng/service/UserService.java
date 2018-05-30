package top.zhuyuncheng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhuyuncheng.dao.UserDao;
import top.zhuyuncheng.dao.UserDaoGroovy;
import top.zhuyuncheng.domain.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
//
    @Autowired
    private UserDaoGroovy userDaoGroovy;

    public int addUser(User user) {
//        return userDao.insert(user);
        return userDaoGroovy.insertUser(user);
    }

    public List<User> userList() {
//        return userDao.selectUsers();
        return userDaoGroovy.userList();
    }

    public User getUser(int userId) {
        return userDaoGroovy.getUser(userId);
    }

    public int updateUser(User user) {
        return userDaoGroovy.updateUser(user);
    }

    public int updateUserName(String uerName, Integer userId) {
        return userDaoGroovy.upateUserName(uerName, userId);
    }


}
