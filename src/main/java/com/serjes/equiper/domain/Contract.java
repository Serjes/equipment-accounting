package com.serjes.equiper.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date receivingDate;

    @OneToMany(mappedBy="contract", fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Device> devices = new HashSet<>();
}
