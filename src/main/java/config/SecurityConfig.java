package config;

// For Spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Represents an authority (role or permission) in Spring Security
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;

// Used to convert KeyCloak roles into Spring Security roles
import org.springframework.security.core.authority.SimpleGrantedAuthority;

// Handling JWT Authentication (Need this to extract authentication info from JWT tokens)
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

// Converter converts one type into another type (keycloak role -> Spring role)
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.Map;

public class SecurityConfig {
}
