package lpnu.service;

import lpnu.dto.BookDTO;
import lpnu.dto.LibraryCardDTO;
import lpnu.dto.OrderDTO;

import java.util.List;

public interface ManagerBookService {
    BookDTO loanBook(long id, BookDTO bookDTO);
    OrderDTO saleBook(List<BookDTO> bookDTOList);
}
