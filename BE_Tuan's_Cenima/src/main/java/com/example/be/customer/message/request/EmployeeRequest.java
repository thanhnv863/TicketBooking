package com.example.be.customer.message.request;

import com.example.be.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeRequest {

    private String code;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private Integer role;

    private Integer status;

    private String createBy;

    private Date createTime;

    public Employee dtoEntity(Employee employee) {
        employee.setAddress(this.address);
        employee.setCreatedBy(this.createBy);
        employee.setEmail(this.email);
        employee.setName(this.name);
        employee.setCode(this.code);
        employee.setRole(this.role);
        employee.setPassword(this.password);
        employee.setPhoneNumber(this.phoneNumber);
        employee.setStatus(this.status);
        employee.setCreatedTime(this.createTime);
        return employee;
    }

}
