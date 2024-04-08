package org.fve.microservices.adminservice;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Collections;

//@SpringBootApplication
@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class AdminServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

	@Bean
	CorsWebFilter corsWebFilter() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Collections.singletonList("*"));
		corsConfig.setAllowCredentials(false);
		corsConfig.setAllowedHeaders(Collections.singletonList("*"));
		corsConfig.setAllowedMethods(Collections.singletonList("*"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}

	@Profile("secure")
	@Configuration(proxyBeanMethods = false)
	public static class SecuritySecureConfig extends WebSecurityConfigurerAdapter {

		private final String adminContextPath;

		private final AdminServerProperties adminServer;

		private final SecurityProperties security;

		public SecuritySecureConfig(AdminServerProperties adminServerProperties, SecurityProperties security) {
			this.adminContextPath = adminServerProperties.getContextPath();
			this.adminServer = adminServerProperties;
			this.security = security;
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
			successHandler.setTargetUrlParameter("redirectTo");
			successHandler.setDefaultTargetUrl(this.adminContextPath + "/");

			http.authorizeRequests((authorizeRequests) -> authorizeRequests
							.antMatchers(this.adminContextPath + "/assets/**")
							.permitAll()
							.antMatchers(this.adminContextPath + "/login")
							.permitAll()
							.anyRequest()
							.authenticated())
					.formLogin((formLogin) ->
							formLogin.loginPage(this.adminContextPath + "/login")
									.successHandler(successHandler)
					)
					.logout((logout) ->
							logout.logoutUrl(this.adminContextPath + "/logout")
					)
					.httpBasic(Customizer.withDefaults())
					.csrf((csrf) ->
							csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
									.ignoringRequestMatchers(
											new AntPathRequestMatcher(this.adminContextPath + "/instances",
													HttpMethod.POST.toString()),
											new AntPathRequestMatcher(this.adminContextPath + "/instances/*",
													HttpMethod.DELETE.toString()),
											new AntPathRequestMatcher(this.adminContextPath + "/actuator/**")
									)
					)
					.rememberMe((rememberMe) ->
							rememberMe
									.key(UUID.randomUUID().toString())
									.tokenValiditySeconds(1209600)
					);

		}

		// Required to provide UserDetailsService for "remember functionality"
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser(security.getUser().getName())
					.password("{noop}" + security.getUser().getPassword()).roles("USER");
		}

	}

}
