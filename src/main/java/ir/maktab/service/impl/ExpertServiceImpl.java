package ir.maktab.service.impl;

import ir.maktab.dao.ExpertRepository;
import ir.maktab.data.enums.ExpertRegistrationStatus;
import ir.maktab.data.enums.Role;
import ir.maktab.data.model.Expert;
import ir.maktab.data.model.Wallet;
import ir.maktab.exception.NotAllowedToAccess;
import ir.maktab.exception.NotCorrectInputException;
import ir.maktab.service.ExpertService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ExpertServiceImpl implements ExpertService {
    private static ExpertService expertService;
    private final ExpertRepository expertRepository = ExpertRepository.getInstance();

    private ExpertServiceImpl() {
    }

    public static ExpertService getInstance() {
        if (expertService == null)
            return new ExpertServiceImpl();
        return expertService;
    }

    @Override
    public void save(Expert expert) {
        expert.setUsername(expert.getEmail());
        expert.setRole(Role.EXPERT);
        expert.setExpertRegistrationStatus(ExpertRegistrationStatus.NEW);
        expert.setExpertTotalScore(0.0);
        expert.setWallet(new Wallet(0.0));
        expertRepository.save(expert);
    }

    @Override
    public void update(Expert expert) {
        expertRepository.update(expert);
    }

    @Override
    public void softDelete(Expert expert) {
        expert.setDeleted(true);
        expertRepository.softDelete(expert);
    }

    @Override
    public List<Expert> findAllWithNewExpertRegistrationStatus() {
        return expertRepository.findAllWithNewExpertRegistrationStatus();
    }

    @Override
    public Expert login(String username, String password) {
        Expert expert = expertRepository.findByUsername(username);
        if (!expert.getExpertRegistrationStatus().equals(ExpertRegistrationStatus.CONFIRMED))
            throw new NotAllowedToAccess("you can not access to services, wait for manager confirm");
        if (!expert.getPassword().equals(password))
            throw new NotCorrectInputException("the password is not correct");
        return expert;
    }

    @Override
    public void changePassword(String newPassword, Expert expert) {
        expert.setPassword(newPassword);
        expertRepository.update(expert);
    }

    public byte[] getExpertImageFromFile(String imagePath) throws IOException {
        File file = new File(imagePath);
        byte[] bytes = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            fileInputStream.read(bytes);
        }
        return bytes;
    }

    @Override
    public boolean isExist(String email) {
        return expertRepository.isExist(email);
    }
}
