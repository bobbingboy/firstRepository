package tw.bobbyko.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder(); //specify the form password are encoded.
		
		String username_1 = "admin"; 
		String password_1 = "12345678"; 
		
		String username_2 = "nimda"; 
		String password_2 = "87654321";
		
		//1:list().get(0).getaccount()
		//2:list().get(0).getpwd()
		
		
		
		auth.inMemoryAuthentication() //verification data are stored in Memort
		.passwordEncoder(pwdEncoder)
		.withUser(username_1).password(pwdEncoder.encode(password_1)).roles("ADMIN", "MEMBER")
		.and()
		.withUser(username_2).password(pwdEncoder.encode(password_2)).roles("MEMBER");
	}
	
}
