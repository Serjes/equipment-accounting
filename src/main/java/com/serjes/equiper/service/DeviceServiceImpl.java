package com.serjes.equiper.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.serjes.equiper.domain.Contract;
import com.serjes.equiper.domain.Device;
import com.serjes.equiper.domain.Location;
import com.serjes.equiper.domain.dto.DeviceDto;
import com.serjes.equiper.repository.DeviceRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DeviceServiceImpl implements DeviceService {

    private static final String DEVICE_HYSTRIX_TIMEOUT = "2000";

    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    @HystrixCommand(commandKey = "addDevice", groupKey = "LibraryService",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = DEVICE_HYSTRIX_TIMEOUT)
            }
    )
    public void addDevice(DeviceDto deviceDto) {

        Contract contract = new Contract();
        Location currentLocation = new Location();
        Location plannedLocation = new Location();

        Device device = new Device(
                deviceDto.getName(),
                deviceDto.getModel(),
                deviceDto.getDescription(),
                deviceDto.getSerialNumber(),
                deviceDto.getInventoryNumber(),
                deviceDto.getMounted(),
                deviceDto.getInStock(),
                currentLocation,
                plannedLocation,
                contract,
                deviceDto.getComment()
        );

        deviceRepository.save(device);
    }
}
