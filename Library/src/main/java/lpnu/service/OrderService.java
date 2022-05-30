package lpnu.service;

import lpnu.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrder();
    OrderDTO getOrderId(long id);
    OrderDTO updateOrder(OrderDTO orderDTO);
    OrderDTO saveOrder(OrderDTO orderDTO);
    double getTotalPriceId(long id);
    void deleteOrderId(long id);
}
