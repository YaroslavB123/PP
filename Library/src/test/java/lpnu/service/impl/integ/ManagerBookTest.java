package lpnu.service.impl.integ;

import lpnu.Application;
import lpnu.dto.BookDTO;
import lpnu.dto.LibraryCardDTO;
import lpnu.dto.UserDTO;

import lpnu.service.BookService;
import lpnu.service.LibraryCardService;
import lpnu.service.ManagerBookService;
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
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ManagerBookTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ManagerBookService managerBookService;
    @Autowired
    private LibraryCardService libraryCardService;

    @Autowired
    private BookService bookService;

    @Test
    public void loanBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        final LibraryCardDTO libraryCard = new LibraryCardDTO(1L,new UserDTO(),new ArrayList<>());
        libraryCardService.saveLibraryCard(libraryCard);

        bookService.saveBook(book);
        bookService.saveBook(book);

        mvc.perform(get("/managers/loanbook/"+book.getId()).contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(book))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
    @Test
    public void saleBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        final List<BookDTO> bookDTOList = new ArrayList<>();
        bookDTOList.add(book);
        bookService.saveBook(book);
        bookService.saveBook(book);
        bookService.saveBook(book);

        mvc.perform(get("/managers/salebook").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(bookDTOList))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(10.0)));
    }
}
