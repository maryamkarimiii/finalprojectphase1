package ir.maktab.data.model;

import ir.maktab.data.enums.UserRole;
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
    UserRole userRole;
    String firstName;
    String lastName;
    @Column(unique = true, length = 11, nullable = false)
    String phoneNumber;
    @Column(unique = true, nullable = false)
    String email;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    Date registerDate;
    @OneToOne
    Wallet wallet;
    @Column(unique = true)
    String username;
    @Column(length = 8)
    String password;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
