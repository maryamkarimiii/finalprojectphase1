package ir.maktab.data.model;

import ir.maktab.data.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    Role role;
    String fullName;
    @Column(unique = true)
    String username;
    String password;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
