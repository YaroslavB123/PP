package lpnu.repository;

import lpnu.entity.Book;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private final Map<Book, Integer> bookIntegerMap = new HashMap<>();
    private long id = 1;

    public Integer amountBook(final Book book) {
        final Book book1 = bookIntegerMap.keySet().stream()
                .filter(e -> e.equals(book))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "book not found"));
        if (bookIntegerMap.get(book) > 0) {
            return bookIntegerMap.get(book);
        } else {
            return 0;
        }

    }

    public List<Book> getAllBook() {
        return new ArrayList<>(bookIntegerMap.keySet());
    }

    public Book getBookId(final long id) {
        return bookIntegerMap.keySet().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Book with id {" + id + "} not found"));
    }

    public Book saveBook(final Book book) {
        book.setId(id++);

        bookIntegerMap.put(book, 1);

        return book;
    }

    public Book saveBook(final Book book, final int value) {
        bookIntegerMap.put(book, value);

        return book;
    }

    public Book updateBook(final Book book) {
        final Book savedBook = getBookId(book.getId());

        savedBook.setName(book.getName());
        savedBook.setYearOfPublication(book.getYearOfPublication());
        savedBook.setAuthor(book.getAuthor());

        return book;
    }

    public void deleteBookId(final long id) {

        final Book book = bookIntegerMap.keySet().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Book with id {" + id + "} not found"));
        bookIntegerMap.remove(book);

    }
}


