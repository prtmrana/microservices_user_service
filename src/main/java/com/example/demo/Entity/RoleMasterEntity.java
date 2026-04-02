package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ROLE_MASTER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMasterEntity {

    @Id
    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "ROLE_DEPT")
    private String roleDept;

    @Column(name = "ROLE_SHORTNAME")
    private String roleShortname;

    @Column(name = "ROLE_POSITION")
    private String rolePosition;

    @Column(name = "STATUS_FLG")
    private String statusFlg;

    @Column(name = "ROLE_STATUS")
    private String roleStatus;

    @Column(name = "MAKER_TIMESTAMP")
    private LocalDateTime makerTimestamp;

    @Column(name = "MAKER_ID")
    private String makerId;

    @Column(name = "CHECKER_TIMESTAMP")
    private LocalDateTime checkerTimestamp;

    @Column(name = "CHECKER_ID")
    private String checkerId;

    @Column(name = "MODULE_CODE")
    private String moduleCode;

    @Column(name = "ROLE_OFC_AVAILABILITY")
    private String roleOfcAvailability;

    @Column(name = "DEFAULT_ACCESS_FLG")
    private String defaultAccessFlg;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "ROLE_SEQUENCE")
    private Long roleSequence;

    @Column(name = "ROLE_PRIORITY")
    private String rolePriority;

    @Column(name = "MENU_JSON")
    private String menuJson;
}