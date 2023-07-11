package com.example.be.customer.service.impl;

import com.example.be.entity.Chair;
import com.example.be.entity.ChairType;
import com.example.be.entity.Room;
import com.example.be.repository.ChairRepository;
import com.example.be.repository.ChairTypeRepository;
import com.example.be.customer.message.request.ChairRequest;
import com.example.be.customer.message.response.ChairResponse;
import com.example.be.customer.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChairServiceImpl implements ChairService {
    @Autowired
    private ChairRepository chairRepository;
    @Autowired
    private ChairTypeRepository chairTypeRepository;

    @Override
    public Page<ChairResponse> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<ChairResponse> chairResponses = chairRepository.findAll(pageable).map(chair -> convertChairToChairRes(chair));
        return chairResponses;
    }

    @Override
    public void save(ChairRequest chairRequest) {
        ChairType chairType = chairTypeRepository.findById(chairRequest.getIdChairType()).get();
        //fix cung room
        Room room = Room.builder()
                .id(1L)
                .name("P001")
                .totalChair(30)
                .status(1)
                .createdBy("NV001")
                .createdTime(new Date())
                .build();
        Chair chair = Chair.builder()
                .chairType(chairType)
                .createdBy(chairRequest.getCreatedBy())
                .createdTime(new Date())
                .room(room)
                .waitTime(chairRequest.getWaitTime())
                .name(chairRequest.getName())
                .status(chairRequest.getStatus())
                .build();
        chairRepository.save(chair);
    }

    @Override
    public void delete(Long id) {
        Chair chair = chairRepository.findById(id).get();
        chair.setStatus(0);
        chairRepository.save(chair);
    }

    @Override
    public void update(Long id, ChairRequest chairRequest) {
        //fix created by, updated by
        ChairType chairType = chairTypeRepository.findById(chairRequest.getIdChairType()).get();
        Chair chair = chairRepository.findById(id).get();
        Room room = Room.builder()
                .id(1L)
                .name("P001")
                .totalChair(30)
                .status(1)
                .createdBy("NV001")
                .createdTime(new Date())
                .build();
        chair.setName(chairRequest.getName());
        chair.setChairType(chairType);
        chair.setRoom(room);
        chair.setStatus(chairRequest.getStatus());
        chair.setUpdatedBy("NV001");
        chair.setUpdatedTime(new Date());
        chairRepository.save(chair);
    }

    private ChairResponse convertChairToChairRes(Chair chair) {
        //fix cung roomName tai chua co RepoRoom

        //0 -ngung hoat dong
        //1- trong
        //2 -dang chon
        //3- da dat
        ChairType chairType = chairTypeRepository.findById(chair.getChairType().getId()).get();
        String status;
        if (chair.getStatus() == 0) {
            status = "Ngung hoat dong";
        } else if (chair.getStatus() == 1) {
            status = "Trong";
        } else if (chair.getStatus() == 2) {
            status = "Dang chon";
        } else if (chair.getStatus() == 3) {
            status = "Da dat";
        } else {
            status = "Khong xac dinh";
        }
        ChairResponse chairResponse = ChairResponse.builder()
                .chairTypeName(chairType.getName())
                .status(status)
                .name(chair.getName())
                .roomName("Phong 1")
                .build();
        return chairResponse;
    }

}
