package com.biotalk.biotalk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.biotalk.biotalk.model.Login;
import com.biotalk.biotalk.repository.LoginRepository;

@Configuration
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Login login = loginRepository.findByEmail(email);
		
		UserBuilder builder = null;
		
		if (login != null) {
		      builder = org.springframework.security.core.userdetails.User.withUsername(email);
		      builder.password(new BCryptPasswordEncoder().encode(login.getPassword()));
		      builder.roles(login.getAuth().getAuthority());
		    } else {
		      throw new UsernameNotFoundException("Usuário não encontrado");
		    }
		
		return builder.build();
	}

}
