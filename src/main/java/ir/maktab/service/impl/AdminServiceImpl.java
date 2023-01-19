package ir.maktab.service.impl;

import ir.maktab.dao.AdminRepository;
import ir.maktab.data.enums.ExpertRegistrationStatus;
import ir.maktab.data.enums.Role;
import ir.maktab.data.model.Admin;
import ir.maktab.data.model.Expert;
import ir.maktab.data.model.Service;
import ir.maktab.data.model.SubService;
import ir.maktab.exception.DuplicationException;
import ir.maktab.exception.NotFoundException;
import ir.maktab.service.*;

import java.util.List;
import java.util.Map;

public class AdminServiceImpl implements AdminService {
    private static AdminService adminService;
    private final AdminRepository adminRepository = AdminRepository.getInstance();
    private final ServiceService servicesService = ServicesServiceImpl.getInstance();
    private final SubServiceService subServiceService = SubServiceServiceImpl.getInstance();
    private final ExpertService expertService = ExpertServiceImpl.getInstance();

    private AdminServiceImpl() {
    }

    public static AdminService getInstance() {
        if (adminService == null)
            return new AdminServiceImpl();
        return adminService;
    }

    public void addNewService(Service service) {
        if (servicesService.isExist(service.getName()))
            throw new DuplicationException("the service is already exist");
        servicesService.save(service);
    }

    public void addNewSubService(SubService subService) {
        if (subServiceService.isExist(subService.getName()))
            throw new DuplicationException("the subService is already exist");
        subServiceService.save(subService);
    }

    public List<Service> seeALLEnableService() {
        return servicesService.findAllEnableService();
    }

    public Map<Service, List<SubService>> seeALLEnableSubService() {
        return subServiceService.findAllEnableSubService();
    }

    public List<Expert> seeAllExpertWithNewExpertRegistrationStatus() {
        return expertService.findAllWithNewExpertRegistrationStatus();
    }

    public void deleteExistenceService(Service service) {
        if (!servicesService.isExist(service.getName()))
            throw new NotFoundException("the service doesnt exist");
        service.setDeleted(true);
        servicesService.softDelete(service);
    }

    public void deleteExistenceSubService(SubService subService) {
        if (!subServiceService.isExist(subService.getName()))
            throw new NotFoundException("the subService doesnt exist");
        subService.setDeleted(true);
        subServiceService.softDelete(subService);
    }

    public void confirmExpert(Expert expert) {
        expert.setExpertRegistrationStatus(ExpertRegistrationStatus.CONFIRMED);
        expertService.update(expert);
    }

    public void addExpertToSubService(Expert expert, SubService subService) {
        if (!expertService.isExist(expert.getEmail()))
            throw new NotFoundException("the expert doesnt exist");
        if (!subServiceService.isExist(subService.getName()))
            throw new NotFoundException("the subService doesnt exist");
        subService.getExpertSet().add(expert);
        subServiceService.update(subService);
    }

    public void deleteExpertFromSubService(Expert expert, SubService subService) {
        if (!expertService.isExist(expert.getEmail()))
            throw new NotFoundException("the expert doesnt exist");
        if (!subServiceService.isExist(subService.getName()))
            throw new NotFoundException("the subService doesnt exist");
        subService.getExpertSet().remove(expert);
        subServiceService.update(subService);
    }

    public void updateSubServicePrice(SubService subService, double newPrice) {
        subServiceService.updateSubServicePrice(subService, newPrice);
    }

    public void updateSubServiceDescription(SubService subService, String newDescription) {
        subServiceService.updateSubServiceDescription(subService, newDescription);
    }

    @Override
    public void save(Admin admin) {
        admin.setRole(Role.Admin);
        adminRepository.save(admin);
    }

    @Override
    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    @Override
    public void softDelete(Admin admin) {
        admin.setDeleted(true);
        adminRepository.softDelete(admin);
    }
}
