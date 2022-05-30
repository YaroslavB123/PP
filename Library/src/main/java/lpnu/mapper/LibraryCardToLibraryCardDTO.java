package lpnu.mapper;

import lpnu.dto.LibraryCardDTO;
import lpnu.entity.LibraryCard;
import org.springframework.stereotype.Component;

@Component
public class LibraryCardToLibraryCardDTO {

    UserToUserDTOMapper userDTOMapper;
    BookListMapper booklistMapper;

    public LibraryCardToLibraryCardDTO(final UserToUserDTOMapper userDTOMapper, final BookListMapper booklistMapper) {
        this.userDTOMapper = userDTOMapper;
        this.booklistMapper = booklistMapper;
    }
    public LibraryCard toEntity(final LibraryCardDTO libraryCardDTO){
        final LibraryCard libraryCard = new LibraryCard();

        libraryCard.setId(libraryCardDTO.getId());
        libraryCard.setUser(userDTOMapper.toEntity(libraryCardDTO.getUserDTO()));
        libraryCard.setBook(booklistMapper.toEntity(libraryCardDTO.getBookDTO()));

        return libraryCard;
    }

    public LibraryCardDTO toDTO(final LibraryCard libraryCard){
        final LibraryCardDTO libraryCardDTO = new LibraryCardDTO();

        libraryCardDTO.setId(libraryCard.getId());
        libraryCardDTO.setUserDTO(userDTOMapper.toDTO(libraryCard.getUser()));
        libraryCardDTO.setBookDTO(booklistMapper.toDTO(libraryCard.getBook()));

        return libraryCardDTO;
    }
}