package top.zhuyuncheng.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zhuyuncheng.domain.model.User;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
    }

    @Test
    public void userList() {
        List<User> users = userService.userList();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() {
        User user = userService.getUser(1006);
        assertTrue(user.getUserId() == 1006);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void updateUserName() {
    }
}