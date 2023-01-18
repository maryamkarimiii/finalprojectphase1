package ir.maktab.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;
    @OneToMany(mappedBy = "service")
    Set<SubService> subServiceSet;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
