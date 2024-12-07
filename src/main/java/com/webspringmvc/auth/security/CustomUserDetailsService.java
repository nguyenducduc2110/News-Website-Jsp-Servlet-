
package com.webspringmvc.auth.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webspringmvc.auth.entity.RoleEntity;
import com.webspringmvc.auth.entity.UserEntity;
import com.webspringmvc.auth.repositoty.UserRepository;
import com.webspringmvc.core.constants.SystemConstant;






@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	
	
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity userEntity =  userRepository.findByUserNameAndStatus(userName, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			throw new UsernameNotFoundException("User not found");
			
		}
		
		List<GrantedAuthority> listRole = new ArrayList<>();
		for (RoleEntity role : userEntity.getRoles()) {
			listRole.add(new SimpleGrantedAuthority(role.getCode()));
			
		}
		
		
		
		
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
				true, true, true, true, listRole);
			myUser.setFullName(userEntity.getFullName());
		return myUser;
	}
	

}
