package com.serjes.equiper.controller;

import com.serjes.equiper.domain.Contract;
import com.serjes.equiper.domain.Device;
import com.serjes.equiper.domain.dto.ContractDto;
import com.serjes.equiper.domain.dto.DeviceDto;
import com.serjes.equiper.repository.ContractRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ContractsRestController {

    private final ContractRepository contractRepository;

    public ContractsRestController(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @GetMapping("/api/contracts")
    public List<ContractDto> listContracts() {
        List<Contract> contractList = contractRepository.findAll();
        return contractList.stream().map(ContractDto::toDto).collect(Collectors.toList());
    }
}
