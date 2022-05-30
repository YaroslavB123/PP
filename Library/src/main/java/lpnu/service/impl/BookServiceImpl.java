package lpnu.service.impl;

import lpnu.dto.BookDTO;
import lpnu.exception.ServiceException;
import lpnu.mapper.BookToBookDTOMapper;
import lpnu.repository.BookRepository;
import lpnu.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookToBookDTOMapper bookDTOMapper;

    public BookServiceImpl(final BookRepository bookRepository, final BookToBookDTOMapper bookDTOMapper) {
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }

    @Override
    public Integer amountBook(final BookDTO bookDTO) {
        return bookRepository.amountBook(bookDTOMapper.toEntity(bookDTO));
    }

    @Override
    public List<BookDTO> getBookForSale() {
        return bookRepository.getAllBook().stream()
                .map(bookDTOMapper::toDTO)
                .filter(e -> amountBook(e) > 1)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getAllBook() {
        return bookRepository.getAllBook().stream()
                .map(bookDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookId(final long id) {
        return bookDTOMapper.toDTO(bookRepository.getBookId(id));
    }

    @Override
    public BookDTO updateBook(final BookDTO bookDTO) {
        if(bookDTO == null){
            throw new ServiceException(400,"Book is null");
        }
        bookRepository.updateBook(bookDTOMapper.toEntity(bookDTO));
        return bookDTO;
    }

    @Override
    public BookDTO saveBook(final BookDTO bookDTO) {

        if(bookDTO == null){
            throw new ServiceException(400,"Book is null");
        }

        if (getAllBook().stream()
                .anyMatch(e -> e.equals(bookDTO)) && amountBook(bookDTO) >= 1) {
            bookRepository.saveBook(bookDTOMapper.toEntity(bookDTO), amountBook(bookDTO) + 1);

        } else {
            bookRepository.saveBook(bookDTOMapper.toEntity(bookDTO));
        }
        return bookDTO;
    }

    @Override
    public void deleteBookOne(final BookDTO bookDTO) {
        if (getAllBook().stream()
                .anyMatch(e -> e.equals(bookDTO)) && amountBook(bookDTO) >= 1) {
            bookRepository.saveBook(bookDTOMapper.toEntity(bookDTO), amountBook(bookDTO) - 1);
        }
    }

    @Override
    public void deleteBookId(final long id) {
        bookRepository.deleteBookId(id);
    }
}
