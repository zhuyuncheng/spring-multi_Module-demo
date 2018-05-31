package top.zhuyuncheng.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addUser() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users")
                .param("userName", "zyc_132")
                .param("password", "zyc_1223")
                .param("phone", "1008611");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void userList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/1006"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateUser() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/users")
                .param("userId", "1006")
                .param("userName", "zyc_132_update")
                .param("password", "zyc_1223_update")
                .param("phone", "1008611");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void patchUser() throws Exception {

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.patch("/users/1006")
                .param("userName", "zyc_132_patch");

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}