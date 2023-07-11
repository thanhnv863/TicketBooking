package com.example.be.service.impl;

import com.example.be.entity.Employee;
import com.example.be.repository.EmployeeRepository;
import com.example.be.employee.message.request.EmployeeRequest;
import com.example.be.service.EmployeeService;
import com.example.be.util.DataUltil;
import com.example.be.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    @Override
    public List<Employee> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return repo.findAll(sort);
    }

    @Override
    public HashMap<String, Object> add(EmployeeRequest employeeRequest) {
        employeeRequest.setStatus(0);
        employeeRequest.setCreateBy("NV1");
        employeeRequest.setCreateTime(DateTimeUtil.getTime());
        Employee employee = employeeRequest.dtoEntity(new Employee());
        try {
            repo.save(employee);
            return DataUltil.setData("success", "Thêm thành công");
        } catch (Exception e) {
            return DataUltil.setData("error", "Thêm thất bại");
        }
    }

    @Override
    public HashMap<String, Object> update(EmployeeRequest employeeRequest, Long id) {
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setStatus(0);
            employee.setName(employeeRequest.getName());
            employee.setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.setEmail(employeeRequest.getEmail());
            employee.setAddress(employeeRequest.getAddress());
            employee.setPassword(employeeRequest.getPassword());
            employee.setRole(employeeRequest.getRole());
            employee.setUpdatedBy("NV1");
            employee.setUpdatedTime(DateTimeUtil.getTime());
            try {
                System.out.println(employee.toString());
                repo.save(employee);
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
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            Employee employee = optional.get();
            employee.setStatus(1);
            try {
                repo.save(employee);
                return DataUltil.setData("success", "Xoá thành công");
            } catch (Exception e) {
                return DataUltil.setData("error", "Xoá thất bại");
            }
        } else {
            return DataUltil.setData("error", "Không tìm thấy đối tượng cần xoá");
        }
    }
}
