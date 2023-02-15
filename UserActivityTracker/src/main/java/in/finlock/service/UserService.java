package in.finlock.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.finlock.entity.User;
import in.finlock.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder pass;
	
	public void saveUser(User user) {
		user.setPassword(pass.encode(user.getPassword()));
		userRepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findById(username).orElseThrow(()-> new RuntimeException());
		
		Collection<SimpleGrantedAuthority> lst = new ArrayList<SimpleGrantedAuthority>();
		lst.add(new SimpleGrantedAuthority("USER"));
		
		return new org.springframework.security.core
				.userdetails.User(user.getUsername(), user.getPassword(), 
						lst);
	}
	
	
}
