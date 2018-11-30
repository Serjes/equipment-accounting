package com.serjes.equiper.controller;

import com.serjes.equiper.domain.Device;
import com.serjes.equiper.domain.dto.DeviceDto;
import com.serjes.equiper.repository.DeviceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeviceRestController {

    private final DeviceRepository deviceRepository;

    public DeviceRestController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/api/devices")
    public List<DeviceDto> listDevices() {
        List<Device> deviceList = deviceRepository.findAll();
        return deviceList.stream().map(DeviceDto::toDto).collect(Collectors.toList());
    }
}
