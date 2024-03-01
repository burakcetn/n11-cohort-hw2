package com.burakcetn.n11bootcampcohorthw2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Order  {


    @Id
    private Integer id;

    private Integer customerId;

    private LocalDateTime createdAt = LocalDateTime.now();


    public Order(int id, int customerId) {
        this.id= id;
        this.customerId = customerId;
    }
}
