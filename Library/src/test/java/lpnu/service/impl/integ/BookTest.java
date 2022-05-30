package lpnu.service.impl.integ;

import lpnu.Application;
import lpnu.dto.BookDTO;
import lpnu.service.BookService;
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
public class BookTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private BookService bookService;

    @Test
    public void saveBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);

        mvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(book))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }

    @Test
    public void deleteBookId_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);

        final BookDTO book1 = new BookDTO(1L, "TestName1", "TestSurname1", 2021);

        bookService.saveBook(book);
        bookService.saveBook(book1);

        mvc.perform(delete("/books/"+book.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(bookService.getAllBook().size(),1);
    }

    @Test
    public void updateBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        final BookDTO book1 = new BookDTO(1L, "TestName1", "TestSurname", 2021);

        bookService.saveBook(book);
        mvc.perform(put("/books").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(book1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName1")));
    }

    @Test
    public void getAllBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        bookService.saveBook(book);

        mvc.perform(get("/books").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }

    @Test
    public void getBookForSale_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        bookService.saveBook(book);
        bookService.saveBook(book);


        mvc.perform(get("/books/sale").contentType(MediaType.APPLICATION_JSON)
                .content((JacksonUtil.serialize(book))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("TestName")));
    }
    @Test
    public void getAmountBook_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        bookService.saveBook(book);
        bookService.saveBook(book);


        mvc.perform(get("/books/amount").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(book))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        assertEquals(bookService.amountBook(book),2);
    }
    @Test
    public void getBookId_thenStatus200() throws Exception {
        final BookDTO book = new BookDTO(1L, "TestName", "TestSurname", 2021);
        bookService.saveBook(book);

        mvc.perform(get("/books/"+book.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("TestName")));
    }
}

