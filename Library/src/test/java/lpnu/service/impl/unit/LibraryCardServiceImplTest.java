package lpnu.service.impl.unit;

import lpnu.dto.LibraryCardDTO;
import lpnu.entity.Book;
import lpnu.entity.LibraryCard;
import lpnu.entity.User;
import lpnu.exception.ServiceException;
import lpnu.mapper.BookToBookDTOMapper;
import lpnu.mapper.LibraryCardToLibraryCardDTO;
import lpnu.mapper.UserToUserDTOMapper;
import lpnu.repository.LibraryCardRepository;
import lpnu.service.LibraryCardService;
import lpnu.service.impl.LibraryCardServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LibraryCardServiceImplTest {
    @Test
    public void test_getLibraryCardId_LibraryCardExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        final LibraryCard libraryCard = new LibraryCard(1L,new User(),new ArrayList<>());

        when(libraryCardRepository.getLibraryCardId(1)).thenReturn(libraryCard);
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        final LibraryCard libraryCard1 = libraryCardRepository.getLibraryCardId(1);

        assertNotNull(libraryCard);
        assertEquals(1L, (long)libraryCard.getId());
    }

    @Test
    public void test_getUserLibraryCard_LibraryCardNotExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        when(libraryCardRepository.getLibraryCardId(1)).thenThrow(new ServiceException(400, "error"));
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        try {
            final LibraryCardDTO libraryCardDTO = libraryCardService.getLibraryCardId(1);
            fail();
        } catch (final ServiceException e) {

        }
    }

    @Test
    public void test_getAllLibraryCard_LibraryCardExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        final LibraryCard libraryCard = new LibraryCard(1L,new User(),new ArrayList<>());
        final List<LibraryCard> libraryCards = new ArrayList<>();
        libraryCards.add(libraryCard);

        when(libraryCardRepository.getAllLibraryCards()).thenReturn(libraryCards);
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        final List<LibraryCard> libraryCard1 = libraryCardRepository.getAllLibraryCards();

        assertNotNull(libraryCard);
        assertEquals(1L, (long) libraryCards.get(0).getId());
    }

    @Test
    public void test_getAllLibraryCard_LibraryCardNoExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        final List<LibraryCard> libraryCard = new ArrayList<>();

        when(libraryCardRepository.getAllLibraryCards()).thenReturn(libraryCard);
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        final List<LibraryCardDTO> libraryCardDTO = libraryCardService.getAllLibraryCards();


        assertEquals(libraryCardDTO,new ArrayList<>());
    }

    @Test
    public void test_saveLibraryCard_LibraryCardExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);
        final UserToUserDTOMapper userMapper = Mockito.mock(UserToUserDTOMapper.class);
        final BookToBookDTOMapper bookMapper = Mockito.mock(BookToBookDTOMapper.class);


        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        final User user = new User(1L,"name","surname","email","pho");
        final List<Book> books =new ArrayList<>();
        books.add(new Book(1L, "name", "author", 10));
        final LibraryCard libraryCard = new LibraryCard(1L,user,books);

        when(libraryCardRepository.saveLibraryCard(libraryCard)).thenReturn(libraryCard);
        when(bookMapper.toDTO(any())).thenCallRealMethod();

        final LibraryCard libraryCard1 = libraryCardRepository.saveLibraryCard(libraryCard);

        assertNotNull(libraryCard1);
        assertEquals(1L, (long)libraryCard1.getId());
    }

    @Test
    public void test_saveLibraryCard_LibraryCardNoExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);
        final User user = new User(1L,"name","surname","email","pho");
        final List<Book> books =new ArrayList<>();
        books.add(new Book(1L, "name", "author", 10));
        final LibraryCard libraryCard = new LibraryCard(1L,user,books);


        when(libraryCardRepository.saveLibraryCard(null)).thenThrow(new ServiceException(400, "user not found"));
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        try {
            final LibraryCardDTO libraryCardDTO = libraryCardService.saveLibraryCard(null);
            fail();
        } catch (final Exception e) {

        }
    }

    @Test
    public void test_updateLibraryCard_LibraryCardExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);
        final LibraryCard libraryCard = new LibraryCard(1L,new User(1L,"name","surname","email","phone"),new ArrayList<>());
        

        when(libraryCardRepository.updateLibraryCard(libraryCard)).thenReturn(libraryCard);
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        final LibraryCard libraryCard1 = libraryCardRepository.updateLibraryCard(libraryCard);

        assertNotNull(libraryCard1);
        assertEquals(1L, (long)libraryCard1.getId());

    }

    @Test
    public void test_updateLibraryCard_LibraryCardNoExist() throws Exception {
        final LibraryCardRepository libraryCardRepository = Mockito.mock(LibraryCardRepository.class);
        final LibraryCardToLibraryCardDTO libraryMapper = Mockito.mock(LibraryCardToLibraryCardDTO.class);

        final LibraryCardService libraryCardService = new LibraryCardServiceImpl(libraryCardRepository, libraryMapper);

        when(libraryCardRepository.updateLibraryCard(null)).thenThrow(new ServiceException(400, "user not found"));
        when(libraryMapper.toDTO(any())).thenCallRealMethod();

        try {
            final LibraryCardDTO libraryCardDTO = libraryCardService.updateLibraryCard(null);
            fail();
        } catch (final ServiceException e) {

        }
    }
}
