package com.Project.FashionCube.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.FashionCube.DTO.UserDTO;
import com.Project.FashionCube.Service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/fashion/user/api/auth/")
public class UserController {
	
	@Autowired
	 UserService userService;
@PostMapping("new")
 public String addUser(@RequestBody UserDTO userDTO) {
	 return userService.addUser(userDTO);
 }
@GetMapping("test")
public String test() {
	return "test is working";
}

@PostMapping("login")
public UserDTO login(@RequestBody UserDTO userDTO) {
	return userService.login(userDTO.getEmail(),userDTO.getPassword());
}
}
