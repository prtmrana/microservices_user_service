package com.example.demo.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "USER_MASTER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMasterEntity {

	    @Id
	    @Column(name = "USER_ID", length = 30)
	    private String userId;

	    @Column(name = "USER_NAME", length = 200)
	    private String userName;

	    @Column(name = "USER_MOBILE", length = 20)
	    private String userMobile;

	    @Column(name = "USER_EMAIL", length = 150)
	    private String userEmail;

	    @Column(name = "USER_ROLE", length = 3000)
	    private String userRole;

	    @Column(name = "USER_OFFICE_ID", length = 200)
	    private String userOfficeId;

	    @Column(name = "USER_LAST_LOGIN_TIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date userLastLoginTime;

	    @Column(name = "USER_LAST_FAIL_LOGIN_TIME")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date userLastFailLoginTime;

	    @Column(name = "USER_PASSWORD", length = 100)
	    private String userPassword;

	    @Column(name = "USER_ACTIVE", length = 10)
	    private String userActive;

	    @Column(name = "USER_EXPIRE_DATE")
	    @Temporal(TemporalType.DATE)
	    private Date userExpireDate;

	    @Column(name = "USER_MAKER_ID", length = 30)
	    private String userMakerId;

	    @Column(name = "MAKER_TIMESTAMP")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date makerTimestamp;

	    @Column(name = "USER_CHECKER_ID", length = 30)
	    private String userCheckerId;

	    @Column(name = "CHECKER_TIMESTAMP")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date checkerTimestamp;

	    @Column(name = "FAILED_LOGIN_ATTEMPT")
	    private Integer failedLoginAttempt;

	    @Column(name = "LAST_PASSWORD_CHANGE_DATE")
	    @Temporal(TemporalType.DATE)
	    private Date lastPasswordChangeDate;

	    @Column(name = "DEPT_ID", length = 30)
	    private String deptId;

	    @Column(name = "SR_NO", length = 30)
	    private String srNo;

	    @Column(name = "SWITCH_ACCESS_FLG", length = 1)
	    private String switchAccessFlg;

	    @Column(name = "CURRENT_ROLE", length = 30)
	    private String currentRole;

	    @Column(name = "BRANCH_ID", length = 30)
	    private String branchId;

	    @Column(name = "VERTICAL", length = 30)
	    private String vertical;

	    @Column(name = "OFFICE_TYPE", length = 50)
	    private String officeType;

	    @Column(name = "CHANNEL_ID", length = 50)
	    private String channelId;

	    @Column(name = "SESSION_ID", length = 100)
	    private String sessionId;

	    @Column(name = "IP_ADDRESS", length = 20)
	    private String ipAddress;

	    @Column(name = "DEVICE_TOKEN", length = 50)
	    private String deviceToken;
	    
//	    @ManyToMany(fetch=FetchType.LAZY)
//	    private Set<RoleMasterEntity> roles;
}
