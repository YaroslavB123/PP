package lpnu.service.impl;

import lpnu.dto.OrderDTO;
import lpnu.mapper.OrderToOrderDTOMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    OrderToOrderDTOMapper orderDTOMapper;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderToOrderDTOMapper orderDTOMapper) {
        this.orderRepository = orderRepository;
        this.orderDTOMapper = orderDTOMapper;
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        return orderRepository.getAllOrders().stream()
                .map(orderDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderId(final long id) {
        return orderDTOMapper.toDTO(orderRepository.getOrdersId(id));
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {
        orderRepository.updateOrder(orderDTOMapper.toEntity(orderDTO));
        return orderDTO;
    }

    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {
        orderRepository.saveOrder(orderDTOMapper.toEntity(orderDTO));
        return orderDTO;
    }

    @Override
    public double getTotalPriceId(final long id) {
        return orderRepository.getOrdersId(id).getBookList().size() * 10;
    }

    @Override
    public void deleteOrderId(final long id) {
        orderRepository.deleteOrderId(id);
    }
}
