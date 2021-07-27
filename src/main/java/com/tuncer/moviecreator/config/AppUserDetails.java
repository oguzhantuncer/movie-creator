package com.tuncer.moviecreator.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tuncer.moviecreator.model.User;

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
	    
	    
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}
		
	    public static AppUserDetails fromDomainUser(User user){
	        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	        authorities.add(new SimpleGrantedAuthority(String.valueOf(user.getRole())));
	        AppUserDetails appUserDetails = new AppUserDetails();
	        appUserDetails.id = String.valueOf(user.getId());
	        appUserDetails.username = user.getUsername();
	        appUserDetails.password = user.getPassword();
	        appUserDetails.email = user.getMail();
	        appUserDetails.grantedAuthorities = authorities;
	        return appUserDetails;
	    }
	
}
