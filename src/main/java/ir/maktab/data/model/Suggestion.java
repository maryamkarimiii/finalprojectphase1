package ir.maktab.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Duration;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Suggestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    Order CustomerOrder;
    @OneToOne
    Expert expert;
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    Date createDate;
    Double price;
    @Temporal(TemporalType.DATE)
    Date dateToWork;
    Duration duration;
    @Column(columnDefinition = "boolean default false")
    boolean isDeleted;
}
