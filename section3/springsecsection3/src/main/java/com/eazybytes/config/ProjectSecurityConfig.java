/*
 * @Author: jackning 270580156@qq.com
 * @Date: 2024-01-27 13:47:16
 * @LastEditors: jackning 270580156@qq.com
 * @LastEditTime: 2024-01-27 14:32:13
 * @Description: bytedesk.com https://github.com/Bytedesk/bytedesk
 *   Please be aware of the BSL license restrictions before installing Bytedesk IM – 
 *  selling, reselling, or hosting Bytedesk IM as a service is a breach of the terms and automatically terminates your rights under the license. 
 *  仅支持企业内部员工自用，严禁用于销售、二次销售或者部署SaaS方式销售 
 *  Business Source License 1.1: https://github.com/Bytedesk/bytedesk/blob/main/LICENSE 
 *  contact: 270580156@qq.com 
 *  技术/商务联系：270580156@qq.com
 * Copyright (c) 2024 by bytedesk.com, All Rights Reserved. 
 */
package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                        .requestMatchers("/notices", "/contact", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
     * NoOpPasswordEncoder is not recommended for production usage.
     * Use only for non-prod.
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*
     * @Bean
     * public InMemoryUserDetailsManager userDetailsService() {
     *//*
        * Approach 1 where we use withDefaultPasswordEncoder() method
        * while creating the user details
        *//*
          *//*
              * UserDetails admin = User.withDefaultPasswordEncoder()
              * .username("admin")
              * .password("12345")
              * .authorities("admin")
              * .build();
              * UserDetails user = User.withDefaultPasswordEncoder()
              * .username("user")
              * .password("12345")
              * .authorities("read")
              * .build();
              * return new InMemoryUserDetailsManager(admin, user);
              *//*
                
                *//*
                    * Approach 2 where we use NoOpPasswordEncoder Bean
                    * while creating the user details
                    *//*
                       * UserDetails admin = User.withUsername("admin")
                       * .password("12345")
                       * .authorities("admin")
                       * .build();
                       * UserDetails user = User.withUsername("user")
                       * .password("12345")
                       * .authorities("read")
                       * .build();
                       * return new InMemoryUserDetailsManager(admin, user);
                       * 
                       * }
                       */

    /*
     * @Bean
     * public UserDetailsService userDetailsService(DataSource dataSource) {
     * return new JdbcUserDetailsManager(dataSource);
     * }
     */

}
