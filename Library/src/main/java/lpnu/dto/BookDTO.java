package lpnu.dto;

import java.util.Objects;

public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private int yearOfPublication;

    public BookDTO() {
    }

    public BookDTO(final Long id, final String name, final String author, final int yearOfPublication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(final int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDTO)) return false;
        final BookDTO bookDTO = (BookDTO) o;
        return getYearOfPublication() == bookDTO.getYearOfPublication() && Objects.equals(getName(), bookDTO.getName()) && Objects.equals(getAuthor(), bookDTO.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getYearOfPublication());
    }
}
