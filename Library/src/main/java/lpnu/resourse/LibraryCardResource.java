package lpnu.resourse;

import lpnu.dto.LibraryCardDTO;
import lpnu.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryCardResource {

    @Autowired
    private LibraryCardService libraryCardService;

    @GetMapping("/libraryCards")
    public List<LibraryCardDTO> getAllLibraryCards(){
        return libraryCardService.getAllLibraryCards();
    }

    @GetMapping("/libraryCards/{id}")
    public LibraryCardDTO getLibraryCardsId(@PathVariable @Validated final long id){
        return libraryCardService.getLibraryCardId(id);
    }

    @PostMapping("/libraryCards")
    public LibraryCardDTO saveLibraryCards(@RequestBody @Validated final LibraryCardDTO libraryCardDTO){
        return libraryCardService.saveLibraryCard(libraryCardDTO);
    }

    @PutMapping("/libraryCards")
    public LibraryCardDTO updateLibraryCardId(@RequestBody @Validated final LibraryCardDTO libraryCardDTO){
        return libraryCardService.updateLibraryCard(libraryCardDTO);
    }

    @DeleteMapping("/libraryCards/{id}")
    public void deleteLibraryCardId(@PathVariable @Validated final long id){
        libraryCardService.deleteLibraryCardId(id);
    }
}
