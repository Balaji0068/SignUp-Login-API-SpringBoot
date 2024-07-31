package com.Project.FashionCube.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.FashionCube.DTO.UserDTO;
import com.Project.FashionCube.Entity.User;
import com.Project.FashionCube.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    UserRepository userRepository;
	
	@Transactional
	@Override
	public String addUser(UserDTO userDTO) {
		User user=new User();
		user.setUserId(userDTO.getUserId()); user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail()); user.setPassword(userDTO.getPassword());
		userRepository.save(user);
		return "Account created successfully";
	}

	@Override
	public UserDTO login(String email, String password) {
		Optional <User>user =userRepository.findByEmail(email);
		
		if(user.isPresent()) {
			User userEntity =user.get();
			
			if(password.equals(userEntity.getPassword())) {
				UserDTO userDTO=new UserDTO();
				userDTO.setUserId(userEntity.getUserId());
				userDTO.setUserName(userEntity.getUserName());
				userDTO.setEmail(userEntity.getEmail());
				return userDTO;
			}else {
				throw new RuntimeException("invalid password");
			}
			
	}else {
		throw new RuntimeException("user not found");
	}
		
	}

}
