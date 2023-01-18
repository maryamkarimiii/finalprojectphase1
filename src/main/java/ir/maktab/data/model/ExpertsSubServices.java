package ir.maktab.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
public class ExpertsSubServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Expert expert;
    @ManyToOne
    SubService subService;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
