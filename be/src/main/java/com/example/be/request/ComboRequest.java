package com.example.be.request;

import com.example.be.entity.Combo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComboRequest {

    private String name;

    private Date startDate;

    private Date endDate;

    private BigDecimal price;

    private Integer status;

    private String createBy;

    private Date createTime;

    public Combo dtoEntity(Combo combo) {
        combo.setStatus(this.status);
        combo.setName(this.name);
        combo.setCreatedBy(this.createBy);
        combo.setEndDate(this.endDate);
        combo.setCreatedTime(this.createTime);
        combo.setPrice(this.price);
        combo.setStartDate(this.startDate);
        return combo;
    }
}
