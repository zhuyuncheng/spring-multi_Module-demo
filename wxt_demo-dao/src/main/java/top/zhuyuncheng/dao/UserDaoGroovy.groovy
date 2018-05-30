package top.zhuyuncheng.dao

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update
import top.zhuyuncheng.domain.model.User

@Mapper
interface UserDaoGroovy {

    @Select("""
        SELECT * FROM t_user
    """)
    List<User> userList()

    @Select("""
        SELECT * FROM t_user WHERE userId = #{userId}
    """)
    User getUser(@Param("userId") int userId)

    @Insert("""
        INSERT INTO t_user (userName, password, phone) VALUES (#{userName}, #{password}, #{phone})
    """)
    Integer insertUser(User user)
    @Update("""
        UPDATE t_user SET userName = #{userName}, password = #{password}, phone = #{phone}
    """)
    Integer updateUser(User user)

    @Update("""
        UPDATE t_user SET userName = #{userName} WHERE userId = #{userId}
    """)
    Integer upateUserName(@Param("userName") String userName,
                          @Param("userId") Integer userId)
}