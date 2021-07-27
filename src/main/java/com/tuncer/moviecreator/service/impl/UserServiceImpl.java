package com.tuncer.moviecreator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuncer.moviecreator.config.AppUserDetails;
import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.repository.UserRepository;
import com.tuncer.moviecreator.util.Constants;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	public String registerUser(User user) {

		if (userRepository.findByUsername(user.getUsername()) == null) {
//			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return Constants.Page.HOME_WITH_REDIRECT;
		} else {
			return Constants.Page.ERROR;
		}

	}
	
    public User selectApplicationUserByUsername(String username){ 
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (selectApplicationUserByUsername(username)!=null)
        {
            AppUserDetails applicationUserDetails = AppUserDetails.fromDomainUser(selectApplicationUserByUsername(username));
            return applicationUserDetails;
        }
        else {
            return null;
        }

    }

}
