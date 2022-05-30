package lpnu.mapper;

import lpnu.dto.BookDTO;
import lpnu.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookListMapper {
    public List<Book> toEntity(final List<BookDTO> bookDTOList){
        final List<Book> bookList = new ArrayList<>();

        for (final BookDTO bookDTO: bookDTOList) {
            final Book book = new Book();

            book.setId(bookDTO.getId());
            book.setName(bookDTO.getName());
            book.setAuthor(bookDTO.getAuthor());
            book.setYearOfPublication(bookDTO.getYearOfPublication());

            bookList.add(book);
        }
        return bookList;
    }

    public List<BookDTO> toDTO(final List<Book> bookList){
        final List<BookDTO> bookDTOList = new ArrayList<>();

        for (final Book book: bookList) {
            final BookDTO bookDTO = new BookDTO();

            bookDTO.setId(book.getId());
            bookDTO.setName(book.getName());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setYearOfPublication(book.getYearOfPublication());

            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }
}
