package com.burakcetn.n11bootcampcohorthw2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Receipt  {


    @Id
    private Integer id;

    private Integer customerId;


    private int bill;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Receipt(int id, int customerId, int bill) {
        this.id = id;
        this.customerId = customerId;
        this.bill = bill;
    }
}
