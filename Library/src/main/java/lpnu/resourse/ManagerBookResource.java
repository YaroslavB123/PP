package lpnu.resourse;

import lpnu.dto.BookDTO;
import lpnu.dto.LibraryCardDTO;
import lpnu.dto.OrderDTO;
import lpnu.service.ManagerBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerBookResource {
    @Autowired
    ManagerBookService managerService;

    @GetMapping("/managers/loanbook/{id}")
    public BookDTO loanBook(@PathVariable @Validated final long id, @RequestBody @Validated final BookDTO bookDTO) {
        return managerService.loanBook(id, bookDTO);
    }

    @GetMapping("/managers/salebook")
    public OrderDTO loanBook(@RequestBody @Validated final List<BookDTO> bookDTO) {
        return managerService.saleBook(bookDTO);
    }
}

