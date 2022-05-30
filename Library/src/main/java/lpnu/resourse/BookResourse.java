package lpnu.resourse;

import lpnu.dto.BookDTO;
import lpnu.entity.Book;
import lpnu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookResourse {

    @Autowired
    private BookService bookService;


    @GetMapping("/books/amount")
    public Integer amountBook(@RequestBody @Validated final BookDTO bookDTO) {
        return bookService.amountBook(bookDTO);
    }

    @GetMapping("/books")
    public List<BookDTO> getAllBook() {
        //return new BookDTO(1,"qew","ew",32);
        return bookService.getAllBook();
    }

    @GetMapping("/books/sale")
    public List<BookDTO> getBookForSale() {
        return bookService.getBookForSale();
    }

    @GetMapping("/books/{id}")
    public BookDTO getBookId(@PathVariable @Validated final long id) {
        return bookService.getBookId(id);
    }

    @PostMapping("/books")
    public BookDTO saveBook(@RequestBody @Validated final BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/books")
    public BookDTO updateBook(@RequestBody @Validated final BookDTO bookDTO) {
        return bookService.updateBook(bookDTO);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookId(@PathVariable @Validated final long id) {
        bookService.deleteBookId(id);
    }
}
