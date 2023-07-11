package com.example.be.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChairResponse {
    private String name;
    private String roomName;
    private String chairTypeName;
    private String status;
}
