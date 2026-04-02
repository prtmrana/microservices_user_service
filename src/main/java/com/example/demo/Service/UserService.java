package com.example.demo.Service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.example.demo.Dto.UserMasterDto;
import com.example.demo.Entity.UserMasterEntity;
import com.example.demo.Repository.UserMasterRepository;
import com.example.demo.customExceptions.UserAlreadyPresentException;
import com.example.demo.customExceptions.UserNotFoundException;

import org.springframework.data.domain.Sort;

@Service
public class UserService {
 
	@Autowired
	private UserMasterRepository userRepo;
	
	@Autowired
	private UserNotificationProducer userNotificationProducer;

	@Cacheable(value = "users", key = "#id")
	public UserMasterDto getById(String  id) {
		 System.out.println("Fetching from DB...");
		UserMasterEntity user = userRepo.findById(id)
		        .orElseThrow(() -> new UserNotFoundException("User not present in database"+id));
		
		
		return UserMasterDto.builder()
				.userId(user.getUserId())
				.branchId(user.getBranchId())
				.deptId(user.getDeptId())
				.ipAddress(user.getIpAddress())
				.deviceToken(user.getDeviceToken())
				.currentRole(user.getCurrentRole())
				.userMobile(user.getUserMobile())
				.userName(user.getUserName())
				.userEmail(user.getUserEmail())
				.build();
	}

	public UserMasterDto saveUser(UserMasterDto userDto) {
		Optional<UserMasterEntity> existingUser = userRepo.findById(userDto.getUserId());

		if (existingUser.isPresent()) {
		    throw new UserAlreadyPresentException(
		        "User already present in database " + userDto.getUserId()
		    );
		}
		
		UserMasterEntity userEntity = UserMasterEntity.builder()
		        .userId(userDto.getUserId())
		        .userName(userDto.getUserName())
		        .userMobile(userDto.getUserMobile())
		        .userEmail(userDto.getUserEmail())
		        .userRole(userDto.getUserRole())
		        .userOfficeId(userDto.getUserOfficeId())
		        .userLastLoginTime(userDto.getUserLastLoginTime())
		        .userLastFailLoginTime(userDto.getUserLastFailLoginTime())
		        .userPassword(userDto.getUserPassword())
		        .userActive(userDto.getUserActive())
		        .userExpireDate(userDto.getUserExpireDate())
		        .userMakerId(userDto.getUserMakerId())
		        .makerTimestamp(userDto.getMakerTimestamp())
		        .userCheckerId(userDto.getUserCheckerId())
		        .checkerTimestamp(userDto.getCheckerTimestamp())
		        .failedLoginAttempt(userDto.getFailedLoginAttempt())
		        .lastPasswordChangeDate(userDto.getLastPasswordChangeDate())
		        .deptId(userDto.getDeptId())
		        .srNo(userDto.getSrNo())
		        .switchAccessFlg(userDto.getSwitchAccessFlg())
		        .currentRole(userDto.getCurrentRole())
		        .branchId(userDto.getBranchId())
		        .vertical(userDto.getVertical())
		        .officeType(userDto.getOfficeType())
		        .channelId(userDto.getChannelId())
		        .sessionId(userDto.getSessionId())
		        .ipAddress(userDto.getIpAddress())
		        .deviceToken(userDto.getDeviceToken())
		        .build();
		userRepo.save(userEntity);
		
		//after saving data
		
		userNotificationProducer.sendUserRegisteredEvent(userDto.getUserEmail());
		
		return UserMasterDto.builder()
				.userId(userDto.getUserId())
				.successFlg(true)
				.build();
	}

	@CachePut(value = "users", key = "#userDto.userId")
	public UserMasterDto updateUser(UserMasterDto userDto) {
		UserMasterEntity user = userRepo.findById(userDto.getUserId())
		        .orElseThrow(() -> new UserNotFoundException("User not present in database"+userDto.getUserId()));
		
		user = UserMasterEntity.builder()
		        .userId(userDto.getUserId())
		        .userName(userDto.getUserName())
		        .userMobile(userDto.getUserMobile())
		        .userEmail(userDto.getUserEmail())
		        .userRole(userDto.getUserRole())
		        .userOfficeId(userDto.getUserOfficeId())
		        .userLastLoginTime(userDto.getUserLastLoginTime())
		        .userLastFailLoginTime(userDto.getUserLastFailLoginTime())
		        .userPassword(userDto.getUserPassword())
		        .userActive(userDto.getUserActive())
		        .userExpireDate(userDto.getUserExpireDate())
		        .userMakerId(userDto.getUserMakerId())
		        .makerTimestamp(userDto.getMakerTimestamp())
		        .userCheckerId(userDto.getUserCheckerId())
		        .checkerTimestamp(userDto.getCheckerTimestamp())
		        .failedLoginAttempt(userDto.getFailedLoginAttempt())
		        .lastPasswordChangeDate(userDto.getLastPasswordChangeDate())
		        .deptId(userDto.getDeptId())
		        .srNo(userDto.getSrNo())
		        .switchAccessFlg(userDto.getSwitchAccessFlg())
		        .currentRole(userDto.getCurrentRole())
		        .branchId(userDto.getBranchId())
		        .vertical(userDto.getVertical())
		        .officeType(userDto.getOfficeType())
		        .channelId(userDto.getChannelId())
		        .sessionId(userDto.getSessionId())
		        .ipAddress(userDto.getIpAddress())
		        .deviceToken(userDto.getDeviceToken())
		        .build();
		userRepo.save(user);
		
		return UserMasterDto.builder()
				.userId(user.getUserId())
				.branchId(user.getBranchId())
				.deptId(user.getDeptId())
				.ipAddress(user.getIpAddress())
				.deviceToken(user.getDeviceToken())
				.currentRole(user.getCurrentRole())
				.userMobile(user.getUserMobile())
				.userName(user.getUserName())
				.userEmail(user.getUserEmail())
				.successFlg(true)
				.build();
	}

	@CacheEvict(value = "users", key = "#userId")
	public String deleteUser(String userId) {
		 userRepo.findById(userId)
		        .orElseThrow(() -> new UserNotFoundException("User not present in database"+userId));
		userRepo.deleteById(userId);
		return "user deleted successfully";
	}

	public Page<UserMasterDto> getAllUsers(int page, int size) {
		Pageable  pageable=PageRequest.of(page, size);
		return userRepo.findAll(pageable);
	}

	public Page<UserMasterDto> getUsersSortByName(int page, int size, String sortBy, String name) {
		 Sort sort = sortBy.equalsIgnoreCase("asc") 
	                ? Sort.by(name).ascending()
	                : Sort.by(name).descending();
		 Pageable pageable = PageRequest.of(page, size, sort);
		 if (name != null && !name.isEmpty()) {
	            return userRepo.findByName(name, pageable);
	        } else {
	            return userRepo.findAll(pageable);
	        }
		
	}
	
	
}
