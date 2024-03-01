package com.burakcetn.n11bootcampcohorthw2.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter

@ToString
public class Customer  {

    @Id
    private Integer id;


    private String name;


    private String sector;

    private LocalDateTime createdAt = LocalDateTime.now();


    public Customer(int id, String name, String sector) {
        this.id = id;
        this.name =name;
        this.sector = sector;
    }
}
