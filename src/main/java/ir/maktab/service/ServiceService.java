package ir.maktab.service;

import ir.maktab.data.model.Order;
import ir.maktab.data.model.Service;

import java.util.List;

public interface ServiceService extends BaseService<Service> {
    Service findServiceByName(String name);

    List<Service> findAllEnableService();

    boolean isExist(String serviceName);
    void softDelete(Service service);
}
