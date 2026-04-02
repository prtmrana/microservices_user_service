package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.UserMasterDto;
import com.example.demo.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/{id}")
	public String getUser(@PathVariable int id) {
		return "i was in user service:" + id;
	}

	@GetMapping("/findByID/{id}")
	public ResponseEntity<UserMasterDto> getById(@PathVariable String id) {
		UserMasterDto dto = userService.getById(id);
		return ResponseEntity.ok(dto);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<UserMasterDto> saveUser(@RequestBody UserMasterDto saveUser) {
		UserMasterDto userDto = userService.saveUser(saveUser);
		return ResponseEntity.ok(userDto);
	}

	@PatchMapping("/updateUser")
	public ResponseEntity<UserMasterDto> updateUser(@RequestBody UserMasterDto saveUser) {
		UserMasterDto userDto = userService.updateUser(saveUser);
		return ResponseEntity.ok(userDto);
	}

	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam String userId) {

		return userService.deleteUser(userId);
	}

	// pagination
	/*
	 * Pagination means dividing large data into smaller chunks (pages) instead of
	 * returning everything at once.
	 * 
	 * Without Pagination ❌ High memory usage Slow response time Network overload UI
	 * becomes slow
	 * 
	 * With Pagination ✅ Faster API Better performance Scalable system
	 * 
	 * 
	 * 
	 * 
	 * Pageable (Interface):::Represents pagination request (input)
	 * 
	 * int getPageNumber();  current page 
	 * int getPageSize(); number of records
	 * Sort getSort(); // sorting
	 * 
	 */
	
	    @GetMapping("/getAllUsers")
	    public Page<UserMasterDto> getUsers(
	    	    @RequestParam(defaultValue = "0") int page,
	    	    @RequestParam(defaultValue = "10") int size) {
		   
		   //Page represents the index of the data chunk starting from 0, 
		   //and size defines how many records should be fetched per page. Internally, 
		    // Spring Data JPA converts it into LIMIT and OFFSET for efficient querying

	        return userService.getAllUsers(page, size);
	    }
	    
	    
	    //Pagination with sorting + filtering
	    
	    @GetMapping("/getAllUsersSortByName")
	    public Page<UserMasterDto> getUsersSortByName(
	    	    @RequestParam(defaultValue = "0") int page,
	    	    @RequestParam(defaultValue = "10") int size,
	    	    @RequestParam(defaultValue = "asc" ) String sort,
	    	    @RequestParam(defaultValue = "userId") String name) {
		   
		   //Page represents the index of the data chunk starting from 0, 
		   //and size defines how many records should be fetched per page. Internally, 
		    // Spring Data JPA converts it into LIMIT and OFFSET for efficient querying

	        return userService.getUsersSortByName(page, size,sort,name);
	    }
	    
}
