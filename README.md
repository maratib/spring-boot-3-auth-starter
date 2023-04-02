# Spring Boot 3 Auth Starter
- Version : 3.0.5  
- Java : 17  
- JUnit : 5  

`Bare minimum Spring Boot 3 Auth Starter with:-`
1. Folder structure  
2. Authentication and Authorization

## Step 1
```xml
<!-- Add security dependency  -->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

## Step 2
Create `auth/SecurityConfig.java` and add the followings to it :-  

### `PasswordEncoder` Bean for password encoding decoding e.g 
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```
<br />

### `UserDetailsService` Bean for user retrieval e.g
```java
@Bean
public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails admin = User.withUsername("admin").password(encoder.encode("admin")).roles("ADMIN").build();
    UserDetails user = User.withUsername("user").password(encoder.encode("user")).roles("USER").build();
    return new InMemoryUserDetailsManager(admin, user);
}
```
<br />

### `SecurityFilterChain` Bean for security filtration e.g
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    // Disable the csrf token
    http.csrf().disable();

    // Set session management to stateless
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    // Set paths for none authentication routs.
    http.authorizeHttpRequests().requestMatchers("/", "/auth/login", "/docs/**").permitAll().anyRequest()
        .authenticated()
        .and()
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        
    return http.build();

}
```
 





