package lpnu.service.impl.integ;

import lpnu.Application;
import lpnu.dto.OrderDTO;
import lpnu.dto.UserDTO;

import lpnu.service.OrderService;
import lpnu.service.UserService;
import lpnu.util.JacksonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class OrderTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderService orderService;


    @Test
    public void saveOrder_thenStatus200() throws Exception {
        final OrderDTO order = new OrderDTO(2L,new ArrayList<>(),11D);

        mvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(order))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(11.0)));
    }
    @Test
    public void updateOrder_thenStatus200() throws Exception {
        final OrderDTO order = new OrderDTO(1L,new ArrayList<>(),11D);

        final OrderDTO order1 = new OrderDTO(1L,new ArrayList<>(),0D);
        orderService.saveOrder(order);

        mvc.perform(put("/orders").contentType(MediaType.APPLICATION_JSON)
                .content(Objects.requireNonNull(JacksonUtil.serialize(order1))))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(0.0)));
    }
    @Test
    public void getAllOrder_thenStatus200() throws Exception {
        final OrderDTO order = new OrderDTO(1L,new ArrayList<>(),11D);
        orderService.saveOrder(order);

        mvc.perform(get("/orders").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].totalPrice", is(11.0)));
    }
    @Test
    public void getOrderId_thenStatus200() throws Exception {
        final OrderDTO order = new OrderDTO(1L,new ArrayList<>(),11D);
        orderService.saveOrder(order);

        mvc.perform(get("/orders/"+order.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.totalPrice", is(11.0)));
    }
    @Test
    public void deleteOrderId_thenStatus200() throws Exception {
        final OrderDTO order = new OrderDTO(1L,new ArrayList<>(),11D);
        orderService.saveOrder(order);

        mvc.perform(delete("/orders/"+order.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertEquals(orderService.getAllOrder().size(),0);
    }
}
