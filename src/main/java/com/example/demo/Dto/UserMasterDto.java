package com.example.demo.Dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMasterDto implements Serializable{

	 private static final long serialVersionUID = 1L;
    private String userId;
    private String userName;
    private String userMobile;
    private String userEmail;
    private String userRole;
    private String userOfficeId;

    private Date userLastLoginTime;
    private Date userLastFailLoginTime;

    // ❌ Don't expose password in response
    private String userPassword;

    private String userActive;
    private Date userExpireDate;

    private String userMakerId;
    private Date makerTimestamp;

    private String userCheckerId;
    private Date checkerTimestamp;

    private Integer failedLoginAttempt;
    private Date lastPasswordChangeDate;

    private String deptId;
    private String srNo;
    private String switchAccessFlg;
    private String currentRole;
    private String branchId;
    private String vertical;
    private String officeType;
    private String channelId;

    private String sessionId;
    private String ipAddress;
    private String deviceToken;
    
    private boolean successFlg;
}