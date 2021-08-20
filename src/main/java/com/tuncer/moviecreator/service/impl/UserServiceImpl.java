package com.tuncer.moviecreator.service.impl;

import com.tuncer.moviecreator.config.AppUserDetails;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.repository.UserRepository;
import com.tuncer.moviecreator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {

        if (userRepository.findByUsername(user.getUsername()) == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return Constants.Page.HOME_WITH_REDIRECT;
        } else {
            return Constants.Page.ERROR;
        }

    }

    public User selectApplicationUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (selectApplicationUserByUsername(username) != null) {
            return AppUserDetails.fromDomainUser(selectApplicationUserByUsername(username));
        } else {
            return null;
        }

    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void fillModel(Model model) {
        model.addAttribute("users", findAll());
    }

}
