package com.fsd.stock.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fsd.stock.auth.feign.UserFeignClient;
import com.fsd.stock.auth.model.AuthUser;


@Service // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			AuthUser authUser = userFeignClient.getUserByName(username);

			if (StringUtils.isEmpty(authUser.getUsername())) {
				throw new UsernameNotFoundException("user " + username + "not exist");
			} else {
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
	                	.commaSeparatedStringToAuthorityList("ROLE_"+authUser.getRole());
				return new User(authUser.getUsername(), authUser.getPassword(), grantedAuthorities);
			}

		} catch (Exception ex) {

			throw new UsernameNotFoundException(ex.getMessage());
		}
		

	}

}
