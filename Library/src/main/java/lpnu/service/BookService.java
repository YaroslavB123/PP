package lpnu.service;

import lpnu.dto.BookDTO;

import java.util.List;

public interface BookService {
    Integer amountBook(BookDTO book);
    List<BookDTO> getAllBook();
    BookDTO getBookId(long id);
    BookDTO updateBook(BookDTO bookDTO);
    BookDTO saveBook(BookDTO bookDTO);
    void deleteBookOne(BookDTO bookDTO);
    List<BookDTO> getBookForSale();
    void deleteBookId(long id);
}
