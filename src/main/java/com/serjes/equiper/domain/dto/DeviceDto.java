package com.serjes.equiper.domain.dto;

import com.serjes.equiper.domain.Contract;
import com.serjes.equiper.domain.Discussion;
import com.serjes.equiper.domain.Location;

import javax.persistence.*;

public class DeviceDto {

    private long id;

    private String name;

    private String model;

    private String description;

    private String serialNumber;

    private String inventoryNumber;

    private Contract contract;

    private Boolean inStock;

    private Location currentLocation;

    private Location plannedLocation;

    private Boolean mounted;

    private String comment;

    private Discussion discussion;
}
