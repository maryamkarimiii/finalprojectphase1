package ir.maktab.service.impl;

import ir.maktab.dao.ServiceRepository;
import ir.maktab.data.model.Service;
import ir.maktab.service.ServiceService;

import java.util.List;

public class ServicesServiceImpl implements ServiceService {
    private static ServiceService serviceService;
    private final ServiceRepository serviceRepository = ServiceRepository.getInstance();

    private ServicesServiceImpl() {
    }

    public static ServiceService getInstance() {
        if (serviceService == null)
            return new ServicesServiceImpl();
        return serviceService;
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void update(Service service) {
        serviceRepository.update(service);
    }

    @Override
    public void softDelete(Service service) {
        service.setDeleted(true);
        serviceRepository.softDelete(service);
    }

    @Override
    public Service findServiceByName(String name) {
        return serviceRepository.findServiceByName(name);
    }

    @Override
    public List<Service> findAllEnableService() {
        return serviceRepository.findAllEnableService();
    }

    @Override
    public boolean isExist(String serviceName) {
        return serviceRepository.isExist(serviceName);
    }
}
