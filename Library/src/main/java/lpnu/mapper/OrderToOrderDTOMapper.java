package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {

    @Autowired
    BookListMapper bookListMapper;

    public Order toEntity(final OrderDTO orderDTO){
        final Order order =new Order();

        order.setId(orderDTO.getId());
        order.setBookList(bookListMapper.toEntity(orderDTO.getBookList()));
        order.setTotalPrice(orderDTO.getTotalPrice());

        return order;
    }

    public OrderDTO toDTO(final Order order){
        final OrderDTO orderDTO =new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setBookList(bookListMapper.toDTO(order.getBookList()));
        orderDTO.setTotalPrice(order.getTotalPrice());
        return orderDTO;
    }
}
