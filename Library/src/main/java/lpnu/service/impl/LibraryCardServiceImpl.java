package lpnu.service.impl;

import lpnu.dto.LibraryCardDTO;
import lpnu.entity.LibraryCard;
import lpnu.mapper.LibraryCardToLibraryCardDTO;
import lpnu.repository.LibraryCardRepository;
import lpnu.service.LibraryCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryCardServiceImpl implements LibraryCardService {

    LibraryCardRepository libraryCardRepository;
    LibraryCardToLibraryCardDTO libraryCardMapper;

    public LibraryCardServiceImpl(final LibraryCardRepository libraryCardRepository, final LibraryCardToLibraryCardDTO libraryCardMapper) {
        this.libraryCardRepository = libraryCardRepository;
        this.libraryCardMapper = libraryCardMapper;
    }

    @Override
    public List<LibraryCardDTO> getAllLibraryCards() {
        return libraryCardRepository.getAllLibraryCards().stream()
                .map(e-> libraryCardMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public LibraryCardDTO getLibraryCardId(final long id) {
        return libraryCardMapper.toDTO(libraryCardRepository.getLibraryCardId(id));
    }

    @Override
    public LibraryCardDTO saveLibraryCard(final LibraryCardDTO libraryCardDTO) {
        libraryCardRepository.saveLibraryCard(libraryCardMapper.toEntity(libraryCardDTO));
        return libraryCardDTO;
    }

    @Override
    public LibraryCardDTO updateLibraryCard(final LibraryCardDTO libraryCardDTO) {
        libraryCardRepository.updateLibraryCard(libraryCardMapper.toEntity(libraryCardDTO));
        return libraryCardDTO ;
    }

    @Override
    public void deleteLibraryCardId(final long id) {
        libraryCardRepository.deleteLibraryCardId(id);
    }
}
