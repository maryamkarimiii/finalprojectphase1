package ir.maktab.service.impl;

import ir.maktab.dao.SubServiceRepository;
import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;
import ir.maktab.exception.NotFoundException;
import ir.maktab.service.SubServiceService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubServiceServiceImpl implements SubServiceService {
    private static SubServiceService subServiceService;
    private final SubServiceRepository subServiceRepository = SubServiceRepository.getInstance();

    private SubServiceServiceImpl() {
    }

    public static SubServiceService getInstance() {
        if (subServiceService == null)
            return new SubServiceServiceImpl();
        return subServiceService;
    }

    @Override
    public void save(SubService subService) {
        subServiceRepository.save(subService);
    }

    @Override
    public void update(SubService subService) {
        subServiceRepository.update(subService);
    }

    @Override
    public void softDelete(SubService subService) {
        subService.setDeleted(true);
        subServiceRepository.softDelete(subService);
    }

    @Override
    public List<SubService> findAllSubServiceByService(Service service) {
        return subServiceRepository.findAllSubServiceByService(service);
    }

    @Override
    public Map<Service, List<SubService>> findAllEnableSubService() {
        List<SubService> subServiceList = subServiceRepository.findAllEnableSubService();
        return subServiceList.stream().collect(Collectors.groupingBy(SubService::getService));
    }

    @Override
    public SubService findSubServiceByName(String subServiceName) {
        return subServiceRepository.findSubServiceByName(subServiceName);
    }

    @Override
    public void updateSubServicePrice(SubService subService, double newPrice) {
        if (!subServiceRepository.isExist(subService.getName()))
            throw new NotFoundException("the subService doesnt exist");
        subService.setBaseAmount(newPrice);
        subServiceRepository.update(subService);
    }

    @Override
    public void updateSubServiceDescription(SubService subService, String newDescription) {
        if (!subServiceRepository.isExist(subService.getName()))
            throw new NotFoundException("the subService doesnt exist");
        subService.setDescription(newDescription);
        subServiceRepository.update(subService);
    }

    @Override
    public boolean isExist(String subServiceName) {
        return subServiceRepository.isExist(subServiceName);
    }
}
