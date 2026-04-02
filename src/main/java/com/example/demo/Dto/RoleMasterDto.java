package com.example.demo.Dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleMasterDto {

    private String roleId;
    private String roleDept;
    private String roleShortname;
    private String rolePosition;
    private String statusFlg;
    private String roleStatus;

    private LocalDateTime makerTimestamp;
    private String makerId;

    private LocalDateTime checkerTimestamp;
    private String checkerId;

    private String moduleCode;
    private String roleOfcAvailability;
    private String defaultAccessFlg;
    private String productName;

    private Long roleSequence;
    private String rolePriority;

    private String menuJson;
}