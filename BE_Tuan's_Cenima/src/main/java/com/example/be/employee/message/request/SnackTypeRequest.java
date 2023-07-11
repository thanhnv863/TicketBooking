package com.example.be.employee.message.request;

import com.example.be.entity.SnackType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SnackTypeRequest {

    private String name;

    private Integer status;

    private String createBy;

    private Date createTime;

    public SnackType dtoEntity(SnackType snackType) {
        snackType.setCreatedBy(this.createBy);
        snackType.setName(this.name);
        snackType.setCreatedTime(this.createTime);
        snackType.setStatus(this.status);
        return snackType;
    }

}
