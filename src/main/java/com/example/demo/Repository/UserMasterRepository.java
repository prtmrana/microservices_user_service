package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Dto.UserMasterDto;
import com.example.demo.Entity.UserMasterEntity;

import io.lettuce.core.dynamic.annotation.Param;

public interface UserMasterRepository extends CrudRepository<UserMasterEntity, String>{

	Optional<UserMasterEntity> findById(String id);

	Page<UserMasterDto> findAll(Pageable pageable);
	
	@Query("SELECT u FROM UserMasterEntity u WHERE u.userName LIKE %:name%")
	Page<UserMasterDto> findByName(@Param("name") String name, Pageable pageable);
}
