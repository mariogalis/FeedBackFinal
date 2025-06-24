package feedback.feedbackfinal.Order;

import feedback.feedbackfinal.Order.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository OrderRepository;

    public OrderService(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    @Transactional
    public Order crearOrder(Order Order) {
        return OrderRepository.save(Order);
    }

    @Transactional(readOnly = true)
    public List<Order> listarOrders() {
        return OrderRepository.findAll();
    }
}
