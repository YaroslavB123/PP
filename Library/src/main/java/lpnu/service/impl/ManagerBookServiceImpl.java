package lpnu.service.impl;

import lpnu.dto.BookDTO;
import lpnu.dto.LibraryCardDTO;
import lpnu.dto.OrderDTO;
import lpnu.exception.ServiceException;
import lpnu.service.BookService;
import lpnu.service.LibraryCardService;
import lpnu.service.ManagerBookService;
import lpnu.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerBookServiceImpl implements ManagerBookService {

    BookService bookService;
    LibraryCardService libraryCardService;
    OrderService orderService;

    public ManagerBookServiceImpl(final BookService bookService, final LibraryCardService libraryCardService, final OrderService orderService) {
        this.bookService = bookService;
        this.libraryCardService = libraryCardService;
        this.orderService = orderService;
    }

    @Override
    public BookDTO loanBook(final long id, final BookDTO bookDTO) {
        if (bookService.getAllBook().stream().anyMatch(bookDTO::equals) && bookService.amountBook(bookDTO) >= 1) {

            final LibraryCardDTO libraryCard = libraryCardService.getAllLibraryCards().stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new ServiceException(400, "Library card with id{ " + id + " } not found"));

            libraryCard.getBookDTO().add(bookDTO);
            libraryCardService.updateLibraryCard(libraryCard);
            bookService.deleteBookOne(bookDTO);

        } else {
            throw new ServiceException(400, "Book with name { " + bookDTO.getName() + " } not found");
        }
        return bookDTO;
    }

    @Override
    public OrderDTO saleBook(final List<BookDTO> bookDTOList) {
        final OrderDTO orderDTO = new OrderDTO(1L, new ArrayList<>(), 0D);

        for (final BookDTO bookDTO : bookDTOList) {
            if (bookService.getBookForSale().stream().anyMatch(bookDTO::equals)) {
                orderDTO.getBookList().add(bookDTO);
                orderDTO.setTotalPrice(orderDTO.getTotalPrice() + 10D);
                bookService.deleteBookOne(bookDTO);
            } else {
                throw new ServiceException(400, "Book with name { " + bookDTO.getName() + " } not found");
            }
        }
        orderService.saveOrder(orderDTO);

        return orderDTO;
    }
}
