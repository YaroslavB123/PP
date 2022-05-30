package lpnu.repository;

import lpnu.entity.Order;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private Long id = 1L;
    private List<Order> orders = new ArrayList<>();

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrdersId(final Long id) {
        return orders.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Order with id {" + id + "} not found"));
    }

    public Order saveOrder(final Order order) {
        if (order == null)
            throw  new ServiceException(400, "Order is null");

        order.setId(id++);
        orders.add(order);

        return order;
    }

    public Order updateOrder(final Order order){
        if (order == null)
            throw  new ServiceException(400, "Order is null");

        final Order savedOrder = getOrdersId(order.getId());

        savedOrder.setBookList(order.getBookList());
        savedOrder.setTotalPrice(order.getTotalPrice());

        return savedOrder;
    }

    public void deleteOrderId(final long id){
        orders = orders.stream()
                .filter(e->e.getId() != id)
                .collect(Collectors.toList());
    }
}
