package com.uti.bankApp.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uti.bankApp.config.repository.UserRepository;
import com.uti.bankApp.models.User;
import com.uti.bankApp.models.dto.UserDTO;



@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority(user));
	}
	
	
	public User loadByUsername(String username) {
		User user = userDao.findByUsername(username);
		return user;
	}
	
	public User save(UserDTO userDTO) {
		User user=new User();
		BeanUtils.copyProperties(userDTO, user);
		user.setUsername(userDTO.getEmail());
		user.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		return userDao.save(user);
	}
	
	private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
//		user.getRoles().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//		});
		return authorities;
	}
}