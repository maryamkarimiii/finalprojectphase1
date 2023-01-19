package ir.maktab.dao;

import ir.maktab.data.model.Admin;

public class AdminRepository extends AbstractRepository<Admin> {
    private static AdminRepository adminRepository;

    private AdminRepository() {
    }

    public static AdminRepository getInstance() {
        if (adminRepository == null)
            return new AdminRepository();
        return adminRepository;
    }
}
