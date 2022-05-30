package lpnu.service;

import lpnu.dto.LibraryCardDTO;

import java.util.List;

public interface LibraryCardService {

    List<LibraryCardDTO> getAllLibraryCards();
    LibraryCardDTO getLibraryCardId(long id);
    LibraryCardDTO saveLibraryCard(LibraryCardDTO libraryCardDTO);
    LibraryCardDTO updateLibraryCard(LibraryCardDTO libraryCardDTO);
    void deleteLibraryCardId(long id);
}
