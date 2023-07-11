package com.example.be.customer.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChairRequest {
    private Long idRoom;
    private Long idChairType;
    private String name;
    private Integer waitTime;
    private Integer status;
    private String createdBy;
    private String updatedBy;
}
