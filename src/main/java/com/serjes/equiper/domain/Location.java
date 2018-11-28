package com.serjes.equiper.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;

    @Column(name="address")
    private String address;

    @Column(name="room")
    private String room;

    @Column(name="rack")
    private String rack;

    @OneToMany(mappedBy="currentLocation", fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Device> devices = new HashSet<>();

    @OneToMany(mappedBy="plannedLocation", fetch=FetchType.LAZY, orphanRemoval = true)
    private Set<Device> devicesPlan = new HashSet<>();


}
