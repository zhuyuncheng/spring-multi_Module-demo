package top.zhuyuncheng.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.zhuyuncheng.domain.model.User;
import top.zhuyuncheng.service.UserService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@MapperScan("top.zhuyuncheng.dao")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String addUser(@ModelAttribute User user) {
        log.info(user.toString());
        return String.valueOf(userService.addUser(user));
    }

    @GetMapping
    @ApiOperation(value = "获取用户列表")
    public List<User> userList() {
        return userService.userList();
    }

    @GetMapping(value = "/{userId}")
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer")
    public User getUser(@PathVariable("userId") Integer userId) {
        return userService.getUser(userId);
    }

    @PutMapping
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    public String updateUser(@ModelAttribute User user) {
        return String.valueOf(userService.updateUser(user));
    }

    @PatchMapping(value = "/{userId}")
    @ApiOperation(value = "更新用户userName字段", notes = "根据url的id来更新用户userName字段")
    public String patchUser(@PathVariable("userId") Integer userId, @RequestParam("userName") String userName) {
        return String.valueOf(userService.updateUserName(userName, userId));
    }


}
