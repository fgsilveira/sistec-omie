package br.com.tecnopon.sistecomie.controller;

import br.com.tecnopon.sistecomie.controller.dto.RepairDto;
import br.com.tecnopon.sistecomie.model.Repair;
import br.com.tecnopon.sistecomie.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairController {

    private final RepairRepository repairRepository;

    @Autowired
    public RepairController(RepairRepository repairRepository) {
        this.repairRepository=repairRepository;
    }

    @GetMapping
    public List<RepairDto> list(String id) {
        List<Repair> repairs = repairRepository.findAll();
        return RepairDto.convert(repairs);
    }
}
