package ir.maktab.data.model;

import ir.maktab.data.enums.ExpertRegistrationStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Expert extends User {
    @Enumerated(EnumType.STRING)
    ExpertRegistrationStatus expertRegistrationStatus;
    @Lob
    byte[] image;
    Double expertTotalScore;
    @ManyToMany
    List<SubService> subServiceSet;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
