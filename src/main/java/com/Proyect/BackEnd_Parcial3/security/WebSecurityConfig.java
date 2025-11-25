package com.Proyect.BackEnd_Parcial3.security;

import com.Proyect.BackEnd_Parcial3.security.jwt.AuthEntryPointJwt;
import com.Proyect.BackEnd_Parcial3.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

}
