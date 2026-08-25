package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.ComplaintStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Complaint {
    @Id
    @GeneratedValue
    private Long complaintId;
    @Column(nullable = false)
    private String reason;
    private String resolutionNote;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ComplaintStatus complaintStatus;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDate complaintDate;
    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complainantId")
    private User complainant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsibleId")
    private User responsible;


}
