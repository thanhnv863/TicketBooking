package com.example.be.service.impl;

import com.example.be.entity.SnackType;
import com.example.be.entity.Snacks;
import com.example.be.repository.SnackRepository;
import com.example.be.request.SnackRequest;
import com.example.be.service.SnackService;
import com.example.be.util.DataUltil;
import com.example.be.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SnackServiceImpl implements SnackService {
    @Autowired
    private SnackRepository repo;

    @Override
    public List<Snacks> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findAll(sort);
    }

    @Override
    public HashMap<String, Object> add(SnackRequest snackRequest) {
        snackRequest.setStatus(0);
        snackRequest.setCreateBy("NV1");
        snackRequest.setCreateTime(DateTimeUtil.getTime());
        Snacks snacks = snackRequest.dtoEntity(new Snacks());
        try {
            repo.save(snacks);
            return DataUltil.setData("success", "Thêm thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Thêm thất bại");
        }
    }

    @Override
    public HashMap<String, Object> update(SnackRequest snackRequest, Long id) {
        Optional<Snacks> optional = repo.findById(id);
        if (optional.isPresent()) {
            Snacks snacks = optional.get();
            snacks.setSnackType(SnackType.builder().id(Long.valueOf(snackRequest.getSnackType())).build());
            snacks.setName(snackRequest.getName());
            snacks.setQuantity(snackRequest.getQuantity());
            snacks.setUnit(snackRequest.getUnit());
            snacks.setPrice(snackRequest.getPrice());
            snacks.setUpdatedBy("NV1");
            snacks.setUpdatedTime(DateTimeUtil.getTime());
            try {
                repo.save(snacks);
                return DataUltil.setData("success", "Sửa thành công");
            } catch (Exception e) {
                return DataUltil.setData("error", "Sửa thất bại");
            }

        } else {
            return DataUltil.setData("error", "Không tìm thấy đối tượng cần sửa");
        }
    }

    @Override
    public HashMap<String, Object> remove(Long id) {
        Optional<Snacks> optional = repo.findById(id);
        if (optional.isPresent()) {
            Snacks snacks = optional.get();
            snacks.setStatus(1);
            try {
                repo.save(snacks);
                return DataUltil.setData("success", "Xoá thành công");
            } catch (Exception e) {
                return DataUltil.setData("error", "Xoá thất bại");
            }

        } else {
            return DataUltil.setData("error", "Không tìm thấy đối tượng cần xoá");
        }
    }

    @Override
    public Page<Snacks> phanTrang(Optional<Integer> optional) {
        PageRequest pageRequest = PageRequest.of(optional.orElse(0), 5);
        return repo.findAll(pageRequest);
    }
}
