package lpnu.service.impl.unit;

import lpnu.dto.BookDTO;
import lpnu.entity.Book;
import lpnu.exception.ServiceException;
import lpnu.mapper.BookToBookDTOMapper;
import lpnu.repository.BookRepository;
import lpnu.service.BookService;

import lpnu.service.impl.BookServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BookServiceImplTest {
    @Test
    public void test_getBookId_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

         final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.getBookId(1)).thenReturn(book);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final BookDTO bookDTO = bookService.getBookId(1);

        assertNotNull(bookDTO);
        assertEquals(1L,(long) bookDTO.getId());
    }

    @Test
    public void test_getBookId_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        when(bookRepository.getBookId(1)).thenThrow(new ServiceException(400, "Book not found"));
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        try {
            final BookDTO bookDTO = bookService.getBookId(1);
            fail();
        } catch (final ServiceException e) {
        }
    }
    @Test
    public void test_getBookForSale_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);
        final List<Book> books = new ArrayList<>();

        final Book book = new Book(1L, "name", "author", 10);
        books.add(book);
        books.add(book);
        books.add(book);

        when(bookRepository.getAllBook()).thenReturn(books);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final List<BookDTO> bookDTO = bookService.getBookForSale();


        assertNotNull(bookDTO);
        assertEquals(1L,(long) bookDTO.get(0).getId());
    }
    @Test
    public void test_getBookForSale_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);
        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final List<Book> books = new ArrayList<>();

        when(bookRepository.getAllBook()).thenReturn(books);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        assertNotNull(bookService.getBookForSale());
    }
    @Test
    public void test_getAllBook_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);
        final List<Book> books = new ArrayList<>();

        final Book book = new Book(1L, "name", "author", 10);
        books.add(book);

        when(bookRepository.getAllBook()).thenReturn(books);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final List<BookDTO> bookDTO = bookService.getAllBook();


        assertNotNull(bookDTO);
        assertEquals(1, (long)bookDTO.get(0).getId());
    }

    @Test
    public void test_getAllBook_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);
        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final List<Book> books = new ArrayList<>();

        when(bookRepository.getAllBook()).thenReturn(books);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        assertNotNull(bookService.getAllBook());
    }

    @Test
    public void test_saveBook_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.saveBook(book)).thenReturn(book);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final BookDTO bookDTO = bookService.saveBook(bookMapper.toDTO(book));

        assertNotNull(bookDTO);
        assertEquals(bookMapper.toDTO(book), bookDTO);
    }

    @Test
    public void test_saveBook_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);
        final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.saveBook(null)).thenThrow(new ServiceException(400, "Book is null"));
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        try {
            final BookDTO bookDTO = bookService.saveBook(null);
            fail();
        } catch (final ServiceException e) {

        }
    }

    @Test
    public void test_updateBook_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.updateBook(book)).thenReturn(book);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final BookDTO bookDTO = bookService.saveBook(bookMapper.toDTO(book));

        assertNotNull(bookDTO);
        assertEquals(1L, (long)bookDTO.getId());
    }

    @Test
    public void test_updateBook_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.updateBook(null)).thenThrow(new ServiceException(400, "Book not found"));
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        try {
            final BookDTO bookDTO = bookService.updateBook(null);
            fail();
        } catch (final ServiceException e) {

        }
    }

    @Test
    public void test_amountBook_bookExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        final Book book = new Book(1L, "name", "author", 10);

        when(bookRepository.amountBook(book)).thenReturn(1);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        assertEquals(0, (int)bookService.amountBook(bookMapper.toDTO(book)));
    }

    @Test
    public void test_amountBook_bookNoExist() throws Exception {
        final BookRepository bookRepository = Mockito.mock(BookRepository.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);

        final BookService bookService = new BookServiceImpl(bookRepository, bookMapper);

        when(bookRepository.amountBook(null)).thenThrow(new ServiceException());
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        try {
            final double amount = bookService.amountBook(null);
            fail();
        } catch (final ServiceException e) {

        }
    }

}
