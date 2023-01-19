package ir.maktab.data.model;

import ir.maktab.data.enums.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    Role role;
    String firstName;
    String lastName;
    @Column(unique = true, length = 11, nullable = false)
    String phoneNumber;
    @Column(unique = true, nullable = false)
    String email;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date registerDate;
    @OneToOne(cascade = CascadeType.ALL)
    Wallet wallet;
    @Column(unique = true,nullable = false)
    String username;
    @Column(length = 8,nullable = false)
    String password;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
