package lpnu.resourse;

import lpnu.dto.OrderDTO;
import lpnu.service.OrderService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderId(@PathVariable @Validated final long id) {
        return orderService.getOrderId(id);
    }

    @GetMapping("/orders/price/{id}")
    public double getTotalPrice(@PathVariable @Validated final long id) {
        return orderService.getOrderId(id).getTotalPrice();
    }

    @PostMapping("/orders")
    public OrderDTO saveOrder(@RequestBody @Validated final OrderDTO orderDTO){
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/orders")
    public OrderDTO updateOrder(@RequestBody @Validated final OrderDTO orderDTO){
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrderId(@PathVariable @Validated final long id){
        orderService.deleteOrderId(id);
    }
}
