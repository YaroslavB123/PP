package lpnu.mapper;

import lpnu.dto.BookDTO;
import lpnu.dto.UserDTO;
import lpnu.entity.Book;
import lpnu.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDTOMapper {
    public Book toEntity(final BookDTO bookDTO){
        final Book book = new Book();

        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setYearOfPublication(bookDTO.getYearOfPublication());

        return book;
    }

    public BookDTO toDTO(final Book book){
        final BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setYearOfPublication(book.getYearOfPublication());

        return bookDTO;
    }
}
