package com.example.be.service.impl;

import com.example.be.entity.Combo;
import com.example.be.entity.ComboDetail;
import com.example.be.entity.Snacks;
import com.example.be.repository.ComboDetailRepository;
import com.example.be.employee.message.request.ComboDetailRequest;
import com.example.be.service.ComboDetailService;
import com.example.be.util.DataUltil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ComboDetailServiceImpl implements ComboDetailService {
    @Autowired
    private ComboDetailRepository repo;

    @Override
    public List<ComboDetail> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findAll(sort);
    }

    @Override
    public HashMap<String, Object> add(ComboDetailRequest comboDetailRequest) {
        ComboDetail comboDetail = comboDetailRequest.dtoEntity(new ComboDetail());
        try {
            repo.save(comboDetail);
            return DataUltil.setData("success", "Thêm thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Thêm thất bại");
        }
    }

    @Override
    public HashMap<String, Object> update(ComboDetailRequest comboDetailRequest, Long id) {
        Optional<ComboDetail> optional = repo.findById(id);
        if (optional.isPresent()) {
            ComboDetail comboDetail = optional.get();
            comboDetail.setCombo(Combo.builder().id(Long.valueOf(comboDetailRequest.getCombo())).build());
            comboDetail.setSnacks(Snacks.builder().build().builder().id(Long.valueOf(comboDetailRequest.getSnack())).build());
            comboDetail.setQuantity(comboDetailRequest.getQuantity());
            try {
                repo.save(comboDetail);
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
        try {
            repo.deleteById(id);
            return DataUltil.setData("success", "Xoá thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Xoá thất bại");
        }
    }
}
