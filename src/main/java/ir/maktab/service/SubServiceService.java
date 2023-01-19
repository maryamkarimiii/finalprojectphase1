package ir.maktab.service;

import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;

import java.util.List;
import java.util.Map;

public interface SubServiceService extends BaseService<SubService> {
    List<SubService> findAllSubServiceByService(Service service);

    Map<Service, List<SubService>> findAllEnableSubService();

    SubService findSubServiceByName(String subServiceName);

    void updateSubServicePrice(SubService subService, double newPrice);

    void updateSubServiceDescription(SubService subService, String newDescription);

    boolean isExist(String subServiceName);

    void softDelete(SubService subService);

}
