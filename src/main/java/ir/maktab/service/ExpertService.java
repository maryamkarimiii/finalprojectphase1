package ir.maktab.service;

import ir.maktab.data.model.Expert;

import java.io.IOException;
import java.util.List;

public interface ExpertService extends BaseService<Expert> {
    Expert login(String username, String password);

    void changePassword(String newPassword, Expert expert);

    byte[] getExpertImageFromFile(String imagePath) throws IOException;

    boolean isExist(String email);

    void softDelete(Expert expert);

    List<Expert> findAllWithNewExpertRegistrationStatus();
}
