package ir.maktab.data.model;

import ir.maktab.data.enums.ExpertRegistrationStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    ExpertRegistrationStatus expertRegistrationStatus = ExpertRegistrationStatus.NEW;
    @Lob
    byte[] image;
}