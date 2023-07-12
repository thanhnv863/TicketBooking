package com.example.be.service.impl;

import com.example.be.entity.Combo;
import com.example.be.repository.ComboRepository;
import com.example.be.employee.message.request.ComboRequest;
import com.example.be.service.ComboService;
import com.example.be.util.DataUltil;
import com.example.be.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ComboServiceImpl implements ComboService {

    @Autowired
    private ComboRepository repo;

    @Override
    public List<Combo> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findAll(sort);
    }

    @Override
    public HashMap<String, Object> add(ComboRequest comboRequest) {
        comboRequest.setStatus(0);
        comboRequest.setCreateBy("NV1");
        comboRequest.setCreateTime(DateTimeUtil.getTime());
        Combo combo = comboRequest.dtoEntity(new Combo());
        try {
            repo.save(combo);
            return DataUltil.setData("success", "Thêm thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Thêm thất bại");
        }
    }

    @Override
    public HashMap<String, Object> update(ComboRequest comboRequest, Long id) {
        Optional<Combo> optional = repo.findById(id);
        if (optional.isPresent()) {
            Combo combo = optional.get();
            combo.setStartDate(comboRequest.getStartDate());
            combo.setEndDate(comboRequest.getEndDate());
            combo.setName(comboRequest.getName());
            combo.setPrice(comboRequest.getPrice());
            combo.setUpdatedBy("NV1");
            combo.setUpdatedTime(DateTimeUtil.getTime());
            try {
                repo.save(combo);
                return DataUltil.setData("success", "Sửa thành công");
            } catch (Exception e) {
                return DataUltil.setData("success", "Sửa thành công");
            }
        } else {
            return DataUltil.setData("success", "Không tìm thấy đối tượng cần sửa");
        }
    }

    @Override
    public HashMap<String, Object> remove(Long id) {
        Optional<Combo> optional = repo.findById(id);
        if (optional.isPresent()) {
            Combo combo = optional.get();
            combo.setStatus(1);
            try {
                repo.save(combo);
                return DataUltil.setData("success", "Xoá thành công");
            } catch (Exception e) {
                return DataUltil.setData("success", "Xoá thành công");
            }
        } else {
            return DataUltil.setData("success", "Không tìm thấy đối tượng cần xoá");
        }
    }
}
