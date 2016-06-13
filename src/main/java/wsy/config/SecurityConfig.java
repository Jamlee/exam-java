package wsy.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = Logger.getLogger(WebSecurityConfigurerAdapter.class.getName());

    @Autowired
    @Qualifier("appUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private AppAuthenticationProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("configure default authenticationProvider is AppAuthenticationProvider");
        auth.authenticationProvider(authProvider);
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/index*").authenticated()
                .antMatchers("/student/**").authenticated()
                .antMatchers("/teacher/**").authenticated()
                .antMatchers("/").authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .failureUrl("/login?error=true")
            .and()
            .logout().logoutSuccessUrl("/login")
            .and()
            .csrf().disable();
    }
}
