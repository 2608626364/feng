package com.fengfan.myspringboot.Security;

import com.fengfan.myspringboot.pojo.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<UserDetail> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //把查询到的角色放在这里面 sucurity框架要用
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (UserDetail role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getUserName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
