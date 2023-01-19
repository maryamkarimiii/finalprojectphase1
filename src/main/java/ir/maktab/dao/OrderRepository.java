package ir.maktab.dao;

import ir.maktab.data.model.Order;

public class OrderRepository extends AbstractRepository<Order> {
    private static OrderRepository orderRepository;

    private OrderRepository() {
    }

    public static OrderRepository getInstance() {
        if (orderRepository == null)
            return new OrderRepository();
        return orderRepository;
    }
}
