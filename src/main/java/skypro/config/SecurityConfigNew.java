package skypro.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;
//форма логина и пароля
@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    public SecurityConfigNew(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Sara").password("12345").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("Nike").password("qwerty").roles("IT"))
//                .withUser(userBuilder.username("Tim").password("56789").roles("SECURITY"))
//                .withUser(userBuilder.username("Dan").password("asdfg").roles("DIRECTOR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "IT", "SECURITY", "DIRECTOR")
                .antMatchers("/server_info").hasAnyRole("IT", "SECURITY", "DIRECTOR")
                .antMatchers("/stuff_info").hasAnyRole("SECURITY", "DIRECTOR")
                .antMatchers("/director_info").hasAnyRole("DIRECTOR")
                .and().formLogin().permitAll();//все должны проходить полную проверку
    }
}
