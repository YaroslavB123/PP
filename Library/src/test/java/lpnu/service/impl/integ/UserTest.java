package lpnu.service.impl.integ;

import lpnu.Application;
import lpnu.dto.UserDTO;

import lpnu.service.UserService;
import lpnu.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserService userService;


    @Test
    public void saveUser_thenStatus200() throws Exception {
        final UserDTO newUser = new UserDTO(1L, "TestName", "TestSurname", "test@email", "qwe");
        mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(newUser))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void saveUser_blankFields_thenStatus400() throws Exception {
        final UserDTO newUser = new UserDTO(null, "", "", "", "");
        mvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(newUser))))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void getAllUsers_thenStatus200() throws Exception {
        final UserDTO user = new UserDTO(1L, "TestName", "TestSurname", "test@email", "qwe");
        userService.saveUser(user);

        mvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));

    }

    @Test
    public void getUsersId_thenStatus200() throws Exception {
        final UserDTO user = new UserDTO(1L, "TestName", "TestSurname", "test@email", "qwe");
        userService.saveUser(user);

        mvc.perform(get("/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));

    }

    @Test
    public void updateUser_thenStatus200() throws Exception {
        final UserDTO user = new UserDTO(1L, "TestName", "TestSurname", "test@email", "qwe");
        final UserDTO user1 = new UserDTO(1L, "TestName1", "TestSurname1", "test@email1", "qwe");

        userService.saveUser(user);

        mvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(user1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }

    @Test
    public void deleteUserId_thenStatus200() throws Exception {
        final UserDTO user = new UserDTO(1L, "TestName", "TestSurname", "test@email", "qwe");
        userService.saveUser(user);

        mvc.perform(delete("/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(userService.getAllUser().size(),0);
    }
}