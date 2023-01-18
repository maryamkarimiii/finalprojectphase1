package ir.maktab.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    Expert expert;
    @OneToOne
    Customer customer;
    Integer score;
    String comment;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
