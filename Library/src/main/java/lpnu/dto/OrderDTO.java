package lpnu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderDTO {
    private Long id;
    private List<BookDTO> bookList = new ArrayList<>();
    private Double totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(final Long id, final List<BookDTO> bookList, final Double totalPrice) {
        this.id = id;
        this.bookList = bookList;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void setBookList(final List<BookDTO> bookList) {
        this.bookList = bookList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        final OrderDTO orderDTO = (OrderDTO) o;
        return getId().equals(orderDTO.getId()) && Double.compare(orderDTO.getTotalPrice(), getTotalPrice()) == 0 && Objects.equals(getBookList(), orderDTO.getBookList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookList(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", bookList=" + bookList +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
