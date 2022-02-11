package in.co.ntpc.pradip.VendorRating.VendorRatingAPI;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authz -> authz
            .antMatchers(HttpMethod.GET, "/v1/GetEmployee").hasAuthority("api://581c4b1d-c860-48a1-b57f-c4ac499338ef/Function.Invoke")
            .anyRequest().authenticated())
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());
	}
}
