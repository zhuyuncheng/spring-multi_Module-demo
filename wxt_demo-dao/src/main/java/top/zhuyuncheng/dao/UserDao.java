package top.zhuyuncheng.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zhuyuncheng.domain.model.User;

import java.util.List;

public interface UserDao {

    int insert(User user);

    List<User> selectUsers();
}
