package com.example.be.employee.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChairTypeRequest {
    private String name;
    private Integer status;
    private String createdBy;
//    private Date createdTime;
//
//    @Column(name = "updated_time")
//    private Date updatedTime;
}
