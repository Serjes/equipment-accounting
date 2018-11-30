package com.serjes.equiper.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.serjes.equiper.domain.Device;
import com.serjes.equiper.domain.Remark;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceDto {

    private long id;

    private String name;

    private String model;

    private String description;

    private String serialNumber;

    private String inventoryNumber;

    private String contractName;

    @JsonProperty("isInStock")
    private Boolean inStock;

    private String currentLocation;

    private String plannedLocation;

    @JsonProperty("isMounted")
    private Boolean mounted;

    private String comment;

    private Set<String> discussion;

    public static DeviceDto toDto(Device device) {
        return new DeviceDto(
                device.getId(),
                device.getName(),
                device.getModel(),
                device.getDescription(),
                device.getSerialNumber(),
                device.getInventoryNumber(),
                device.getContract().getName(),
                device.getInStock(),
                device.getCurrentLocation().getCity(),
                device.getPlannedLocation().getCity(),
                device.getMounted(),
                device.getComment(),
                device.getDiscussion().stream().map(Remark::getContent).collect(Collectors.toSet())
        );
    }
}
