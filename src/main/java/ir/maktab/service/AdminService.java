package ir.maktab.service;

import ir.maktab.data.model.Admin;
import ir.maktab.data.model.Expert;
import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;

import java.util.List;
import java.util.Map;

public interface AdminService extends BaseService<Admin> {
    void addExpertToSubService(Expert expert, SubService subService);

    void deleteExpertFromSubService(Expert expert, SubService subService);

    void addNewService(Service service);

    void addNewSubService(SubService subService);

    List<Service> seeALLEnableService();

    Map<Service, List<SubService>> seeALLEnableSubService();

    List<Expert> seeAllExpertWithNewExpertRegistrationStatus();

    void deleteExistenceService(Service service);

    void deleteExistenceSubService(SubService subService);

    void confirmExpert(Expert expert);

    void updateSubServicePrice(SubService subService, double newPrice);

    void updateSubServiceDescription(SubService subService, String newDescription);

    void softDelete(Admin admin);
}
