package lpnu.repository;


import lpnu.entity.LibraryCard;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LibraryCardRepository {

    private List<LibraryCard> libraryCards = new ArrayList<>();
    private long id = 1;

    public List<LibraryCard> getAllLibraryCards() {
        return libraryCards;
    }

    public LibraryCard getLibraryCardId(final long id) {
        return libraryCards.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "LibraryCard with id {" + id + "} not found"));
    }

    public LibraryCard saveLibraryCard(final LibraryCard libraryCard) {

        libraryCard.setId(id++);
        libraryCards.add(libraryCard);

        return libraryCard;
    }

    public LibraryCard updateLibraryCard(final LibraryCard libraryCard) {
        if (libraryCard == null)
            throw  new ServiceException(400, "LibraryCard not found");

        final LibraryCard savedLibraryCard = getLibraryCardId(libraryCard.getId());

        savedLibraryCard.setBook(libraryCard.getBook());
        savedLibraryCard.setUser(libraryCard.getUser());

        return savedLibraryCard;
    }

    public void deleteLibraryCardId(final long id) {
        libraryCards = libraryCards.stream()
                .filter(e -> e.getId() != id)
                .collect(Collectors.toList());
    }
}
