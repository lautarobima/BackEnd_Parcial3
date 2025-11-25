package com.Proyect.BackEnd_Parcial3.security.services;

import com.Proyect.BackEnd_Parcial3.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1;

    private Long id;

    private String name;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static UserDetailsImpl build(Employee emplyee) {
        return new UserDetailsImpl(
                emplyee.getId(),
                emplyee.getName(),
                emplyee.getPassword()
        );
    }

    // Existe el chance de que por la naturaleza de employee, no tenga que usar authorities. Lo tengo por si acaso.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return "";
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return name;
    }

    // No me voy a complicar la vida con mas cosas en estos metodos
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

    /*@Override
    public Collection<? extends  GrantedAuthority> getAuthorities() {
        return authorities;
    }*/

    // Getters y setters

}
