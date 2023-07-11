package com.example.be.service.impl;

import com.example.be.entity.SnackType;
import com.example.be.repository.SnackTypeRepository;
import com.example.be.request.SnackTypeRequest;
import com.example.be.service.SnackTypeService;
import com.example.be.util.DataUltil;
import com.example.be.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SnackTypeServiceImpl implements SnackTypeService {

    @Autowired
    private SnackTypeRepository repo;

    @Override
    public List<SnackType> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findAll(sort);
    }

    @Override
    public HashMap<String, Object> save(SnackTypeRequest snackTypeRequest) {
        snackTypeRequest.setStatus(0);
        snackTypeRequest.setCreateBy("NV1");
        snackTypeRequest.setCreateTime(DateTimeUtil.getTime());
        SnackType snackType = snackTypeRequest.dtoEntity(new SnackType());
        try {
            repo.save(snackType);
            return DataUltil.setData("success", "Thêm thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Thêm thất bại");
        }
    }

    @Override
    public HashMap<String, Object> update(SnackTypeRequest snackTypeRequest, Long id) {
        Optional<SnackType> optional = repo.findById(id);
        if (optional.isPresent()) {
            SnackType snackType = optional.get();
            snackType.setUpdatedBy("NV1");
            snackType.setName(snackTypeRequest.getName());
            snackType.setUpdatedTime(DateTimeUtil.getTime());
            try {
                repo.save(snackType);
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
        Optional<SnackType> optional = repo.findById(id);
        if (optional.isPresent()) {
            SnackType snackType = optional.get();
            snackType.setStatus(1);
            try {
                repo.save(snackType);
                return DataUltil.setData("success", "Xoá thành công");
            } catch (Exception e) {
                return DataUltil.setData("error", "Xoá thất bại");
            }
        } else {
            return DataUltil.setData("error", "Không tìm thấy đối tượng cần xoá");
        }
    }
}
