package com.tuncer.moviecreator.config;

import com.tuncer.moviecreator.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AppUserDetails implements UserDetails {

    private String id;
    private String username;
    private String password;
    private String email;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public static AppUserDetails fromDomainUser(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.id = String.valueOf(user.getId());
        appUserDetails.username = user.getUsername();
        appUserDetails.password = user.getPassword();
        appUserDetails.email = user.getMail();
        appUserDetails.isAccountNonExpired = true;
        appUserDetails.isAccountNonLocked = true;
        appUserDetails.isEnabled = true;
        appUserDetails.isCredentialsNonExpired = true;
        appUserDetails.grantedAuthorities = authorities;
        return appUserDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return isEnabled;
    }

}
