package br.com.tecnopon.sistecomie.controller.dto;

import br.com.tecnopon.sistecomie.model.Repair;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RepairDto {

    private Long id;
    private String customer;
    private String product;
    private String employee;
    private LocalDateTime dateOfCreation;
    private String repairStatus;

    public RepairDto(Repair repair) {
        this.id = repair.getId();
        this.customer = repair.getCustomer().getName();
        this.product = repair.getProduct().getName();
        this.employee = repair.getEmployee().getName();
        this.dateOfCreation = repair.getDateOfCreation();
        this.repairStatus = repair.getRepairStatus().name();
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProduct() {
        return product;
    }

    public String getEmployee() {
        return employee;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public static List<RepairDto> convert(List<Repair> repairs) {
        return repairs.stream().map(RepairDto::new).collect(Collectors.toList());
    }
}
