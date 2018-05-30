package top.zhuyuncheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhuyuncheng.domain.model.User;
import top.zhuyuncheng.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        return String.valueOf(userService.addUser(user));
    }

    @GetMapping
    public List<User> userList() {
        return userService.userList();
    }
    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }

    @PutMapping
    public String updateUser(@ModelAttribute User user) {

        return String.valueOf(userService.updateUser(user));
    }

    @PatchMapping(value = "/{userId}")
    public String patchUser(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName) {
        return String.valueOf(userService.updateUserName(userName, userId));
    }



}
