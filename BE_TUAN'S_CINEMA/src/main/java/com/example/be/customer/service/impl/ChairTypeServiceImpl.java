package com.example.be.customer.service.impl;

import com.example.be.entity.ChairType;
import com.example.be.repository.ChairTypeRepository;
import com.example.be.customer.message.request.ChairTypeRequest;
import com.example.be.customer.service.ChairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChairTypeServiceImpl implements ChairTypeService {
    //status: 0 - Ngung hoat dong. 1- Hoat dong
    //=> save: fix status = 1
//  `id` BIGINT NOT NULL AUTO_INCREMENT,
//  `name` VARCHAR(45) NOT NULL,
//  `status` INT NOT NULL,
//  `created_by` BIGINT NOT NULL,
//  `updated_by` BIGINT NULL,
//  `created_time` VARCHAR(45) NOT NULL,
//  `updated_time` VARCHAR(45) NULL,
    @Autowired
    private ChairTypeRepository chairTypeRepository;

    @Override
    public void save(ChairTypeRequest chairTypeRequest) {
        Date date = new Date();
        ChairType chairType = ChairType.builder()
                .status(chairTypeRequest.getStatus())
                .createdBy(chairTypeRequest.getCreatedBy())
                .name(chairTypeRequest.getName())
                .createdTime(date)
                .build();
        System.out.println(chairType.getCreatedTime());
        chairTypeRepository.save(chairType);
    }

    @Override
    public List<ChairType> getAll() {
        return chairTypeRepository.findAll();
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        ChairType chairType = chairTypeRepository.findById(id).get();
        chairType.setStatus(status);
        chairTypeRepository.save(chairType);
    }
}
