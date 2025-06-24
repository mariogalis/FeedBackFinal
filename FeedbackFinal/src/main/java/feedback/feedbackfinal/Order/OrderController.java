package feedback.feedbackfinal.Order;

import feedback.feedbackfinal.Order.Order;
import feedback.feedbackfinal.Order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService OrderService;

    public OrderController(OrderService OrderService) {
        this.OrderService = OrderService;
    }

    @PostMapping
    public Order crear(@RequestBody Order nuevoOrder) {
        return OrderService.crearOrder(nuevoOrder);
    }

    @GetMapping
    public List<Order> listar() {
        return OrderService.listarOrders();
    }
}
