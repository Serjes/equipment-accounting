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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "snumber")
    private String serialNumber;

    @Column(name = "inumber")
    private String inventoryNumber;

    @Column(name = "mounted")
    private Boolean mounted;

    @Column(name = "instock")
    private Boolean inStock;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;


}
