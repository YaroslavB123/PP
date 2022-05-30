package lpnu.service.impl.integ;


import lpnu.Application;
import lpnu.dto.LibraryCardDTO;
import lpnu.dto.UserDTO;

import lpnu.service.LibraryCardService;
import lpnu.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class LibraryCardTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    LibraryCardService libraryCardService;

    @Test
    public void saveLibraryCard_thenStatus200() throws Exception {
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());

        mvc.perform(post("/libraryCards").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(libraryCard))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }

    @Test
    public void updateLibraryCard_thenStatus200() throws Exception {
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());
        final LibraryCardDTO libraryCard1 = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());

        libraryCardService.saveLibraryCard(libraryCard);

        mvc.perform(put("/libraryCards").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(libraryCard1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }
    @Test
    public void getAllLibraryCard_thenStatus200() throws Exception {
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());

        libraryCardService.saveLibraryCard(libraryCard);

        mvc.perform(get("/libraryCards").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", is(1)));
    }
    @Test
    public void getLibraryCardId_thenStatus200() throws Exception {
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());

        libraryCardService.saveLibraryCard(libraryCard);

        mvc.perform(get("/libraryCards/"+libraryCard.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)));
    }
    @Test
    public void deleteLibraryCard_thenStatus200() throws Exception {
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());

        libraryCardService.saveLibraryCard(libraryCard);

        mvc.perform(delete("/libraryCards/"+libraryCard.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        assertEquals(libraryCardService.getAllLibraryCards().size(),0);
    }
}
