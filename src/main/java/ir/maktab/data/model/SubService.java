package ir.maktab.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, nullable = false)
    String name;
    @Column(nullable = false)
    Double baseAmount;
    @Column(nullable = false)
    String description;
    @ManyToOne
    Service service;
    @ManyToMany(mappedBy = "subServiceSet")
    List<Expert> expertSet;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
