package ir.maktab.service.impl;

import ir.maktab.dao.OrderRepository;
import ir.maktab.data.enums.OrderStatus;
import ir.maktab.data.model.Order;
import ir.maktab.exception.ValidationException;
import ir.maktab.service.OrderService;

import java.util.Date;

public class OrderServiceImpl implements OrderService {
    private static OrderService orderService;
    private final OrderRepository orderRepository = OrderRepository.getInstance();

    private OrderServiceImpl() {
    }

    public static OrderService getInstance() {
        if (orderService == null)
            return new OrderServiceImpl();
        return orderService;
    }

    @Override
    public void save(Order order) {
        validateOrderPrice(order);
        validateOrderDate(order);
        order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_RECOMMENDATION);
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.update(order);
    }

    @Override
    public void softDelete(Order order) {
        order.setDeleted(true);
        orderRepository.softDelete(order);
    }

    public void validateOrderPrice(Order order) {
        if (order.getPrice() < order.getSubService().getBaseAmount())
            throw new ValidationException("the order price must not be less than order price");
    }

    public void validateOrderDate(Order order) {
        if (order.getDateToWork().before(new Date()))
            throw new ValidationException("the date cant be before today");
    }

}
