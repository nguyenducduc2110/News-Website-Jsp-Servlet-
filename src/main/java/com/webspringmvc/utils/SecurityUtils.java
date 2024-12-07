
package com.webspringmvc.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.webspringmvc.auth.security.MyUser;


public class SecurityUtils {
	
	
	
	public static List<String> getAuthorities(){
		List<String> listRoleCode = new ArrayList<String>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			listRoleCode.add(grantedAuthority.getAuthority());
		}
		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new  UsernamePasswordAuthenticationFilter();
		return listRoleCode;
	}
	
	
	public static MyUser getPrincipal() {
		return (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
	}
	
}
