package com.serjes.equiper.domain.dto;

import com.serjes.equiper.domain.Contract;
import com.serjes.equiper.domain.Device;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private long id;

    private String name;

    private String receivingDate;

//    private Set<String> devices;

    public static ContractDto toDto(Contract contract) {
        return new ContractDto(
                contract.getId(),
                contract.getName(),
                contract.getReceivingDate().toString()
//                contract.getDevices().stream().map(Device::getName).collect(Collectors.toSet())
        );
    }
}
