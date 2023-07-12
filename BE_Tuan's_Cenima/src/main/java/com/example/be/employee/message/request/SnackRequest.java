package com.example.be.employee.message.request;

import com.example.be.entity.SnackType;
import com.example.be.entity.Snacks;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class SnackRequest {

    private String name;

    private BigDecimal price;

    private String unit;

    private Integer quantity;

    private String createBy;

    private Date createTime;

    private String snackType;

    private Integer status;

    public Snacks dtoEntity(Snacks snacks) {
        snacks.setStatus(this.status);
        snacks.setName(this.name);
        snacks.setPrice(this.price);
        snacks.setUnit(this.unit);
        snacks.setQuantity(this.quantity);
        snacks.setCreatedBy(this.createBy);
        snacks.setCreatedTime(this.createTime);
        snacks.setSnackType(SnackType.builder().id(Long.valueOf(this.snackType)).build());
        return snacks;
    }

}
