package ir.maktab.data.model;

import ir.maktab.data.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Role role;
    String fullName;
    String username;
    String password;
}
