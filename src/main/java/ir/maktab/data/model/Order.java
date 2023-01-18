package ir.maktab.data.model;

import ir.maktab.data.enums.OrderStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    Integer orderID;
    @OneToOne
    Customer customer;
    @OneToOne
    SubService subService;
    @OneToOne
    Expert expert;
    String description;
    Double price;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date dateToWork;
    @Column(nullable = false)
    String address;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
