package com.serjes.equiper.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "snumber")
    private String serialNumber;

    @Column(name = "inumber")
    private String inventoryNumber;

    @Column(name = "mounted")
    private Boolean mounted;

    @ManyToOne
    @JoinColumn(name = "clocation_id")
    private Location currentLocation;

    @ManyToOne
    @JoinColumn(name = "plocation_id")
    private Location plannedLocation;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "comment")
    private String comment;


}
