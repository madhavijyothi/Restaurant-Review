/*
 * Copyright 2010-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package yelp.web;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/index.html", "/favicon.ico", "/css/**", "/images/**", "/js/**",
			"/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.mvcMatcher("/users/**")
				.authorizeRequests()
					.mvcMatchers(GET,  "/users/**").permitAll()
					.mvcMatchers(POST, "/users").permitAll()
					.and()

			.mvcMatcher("/restaurants/**")
				.authorizeRequests()
					.mvcMatchers(GET,  "/restaurants/**").permitAll()
					.mvcMatchers(GET,  "/restaurants/{id}").permitAll()
					.mvcMatchers(POST,  "/restaurants/{id}/review").permitAll()
					.mvcMatchers(DELETE,  "/restaurants/{id}/review/{id}").permitAll()
					.mvcMatchers(PUT,  "/restaurants/{id}/review/{id}").permitAll()
					.and()
					
			.mvcMatcher("/**")
				.authorizeRequests()
					.mvcMatchers("/**").denyAll()
					.and()

			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()

			.csrf()
				.disable()

			.httpBasic();
		// @formatter:on
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

}
