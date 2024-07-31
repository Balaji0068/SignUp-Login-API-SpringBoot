package com.Project.FashionCube.Service;

import com.Project.FashionCube.DTO.UserDTO;

public interface UserService {
 public String addUser(UserDTO userDTO);
 public UserDTO login(String email, String password);
}
