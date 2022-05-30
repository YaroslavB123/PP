package lpnu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryCard {
    private Long id;
    private User user;
    private List<Book> book = new ArrayList<>();

    public LibraryCard() {
    }

    public LibraryCard(final Long id, final User user, final List<Book> book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(final List<Book> book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryCard)) return false;
        final LibraryCard that = (LibraryCard) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getBook(), that.getBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getBook());
    }

    @Override
    public String toString() {
        return "LibraryCard{" +
                "user=" + user +
                ", book=" + book +
                '}';
    }
}
