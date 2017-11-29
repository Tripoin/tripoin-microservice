/**
 * 
 */
package id.co.tripoin.account.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author <a href="mailto:bagus.sugitayasa@sigma.co.id">GusdeGita</a>
 * @version Id: 
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	private static final String SQL_LOGIN = "select u.username as username, p.password as password, "
            + "active from s_user u inner join s_user_password p on p.id_user = u.id where username = ? ";

    private static final String SQL_PERMISSION = "select u.username, p.permission_value as authority "
            + "from s_user u inner join s_role r on u.id_role = r.id "
            + "inner join s_role_permission rp on rp.id_role = r.id "
            + "inner join s_permission p on rp.id_permission = p.id where u.username = ?";
    
    @Autowired private DataSource dataSource;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    		auth.jdbcAuthentication()
    			.dataSource(dataSource)
    			.passwordEncoder(passwordEncoder())
    			.usersByUsernameQuery(SQL_LOGIN)
    			.authoritiesByUsernameQuery(SQL_PERMISSION);
    }

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    		http.authorizeRequests().antMatchers("/login").permitAll()
    			.antMatchers("/oauth/token/revokeById/**").permitAll()
    			.antMatchers("/tokens/**").permitAll()
    			.anyRequest().authenticated()
    			.and().formLogin().permitAll()
    			.and().csrf().disable();
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    		return super.authenticationManagerBean();
    }
}
