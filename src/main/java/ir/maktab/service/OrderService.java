package ir.maktab.service;

import ir.maktab.data.model.Order;

public interface OrderService extends BaseService<Order> {
    void validateOrderPrice(Order order);

    void validateOrderDate(Order order);

    void softDelete(Order order);
}
