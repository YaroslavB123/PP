package lpnu.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long id;
    private List<Book> bookList = new ArrayList<>();
    private double totalPrice;

    public Order() {
    }

    public Order(final Long id, final List<Book> bookList, final double totalPrice) {
        this.id = id;
        this.bookList = bookList;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(final List<Book> bookList) {
        this.bookList = bookList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        final Order order = (Order) o;
        return getId().equals(order.getId()) && Double.compare(order.getTotalPrice(), getTotalPrice()) == 0 && Objects.equals(getBookList(), order.getBookList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBookList(), getTotalPrice());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", bookList=" + bookList +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
