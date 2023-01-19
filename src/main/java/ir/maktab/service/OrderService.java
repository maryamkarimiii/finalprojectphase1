package ir.maktab.service;

import ir.maktab.data.model.Order;
import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;

import java.util.List;

public interface OrderService extends BaseService<Order> {
    void validateOrderPrice(Order order);

    void validateOrderDate(Order order);

    void softDelete(Order order);
}
