package com.dev.app.ws.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.dev.app.ws.shared.dto.UserDTO;

public interface UserService extends UserDetailsService {

	UserDTO createUser(UserDTO user);

	UserDTO updateUser(String id, UserDTO user);

	UserDTO getUser(String email);

	UserDTO getUserByUserId(String id);

	void deleteUser(String id);

	List<UserDTO> getAllUsers(int page, int limit);

}
