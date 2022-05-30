package lpnu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryCardDTO {
    private Long id;
    private UserDTO userDTO;
    private List<BookDTO> bookDTO = new ArrayList<>();

    public LibraryCardDTO() {
    }

    public LibraryCardDTO(final Long id, final UserDTO userDTO, final List<BookDTO> bookDTO) {
        this.id = id;
        this.userDTO = userDTO;
        this.bookDTO = bookDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(final UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<BookDTO> getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(final List<BookDTO> bookDTO) {
        this.bookDTO = bookDTO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryCardDTO)) return false;
        final LibraryCardDTO that = (LibraryCardDTO) o;
        return getId().equals(that.getId()) && Objects.equals(getUserDTO(), that.getUserDTO()) && Objects.equals(getBookDTO(), that.getBookDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserDTO(), getBookDTO());
    }

    @Override
    public String toString() {
        return "LibraryCardDTO{" +
                "id=" + id +
                ", userDTO=" + userDTO +
                ", bookDTO=" + bookDTO +
                '}';
    }
}
