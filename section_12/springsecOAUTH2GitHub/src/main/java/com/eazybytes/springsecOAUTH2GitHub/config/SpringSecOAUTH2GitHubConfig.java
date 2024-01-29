/*
 * @Author: jackning 270580156@qq.com
 * @Date: 2024-01-27 13:47:16
 * @LastEditors: jackning 270580156@qq.com
 * @LastEditTime: 2024-01-29 10:53:21
 * @Description: bytedesk.com https://github.com/Bytedesk/bytedesk
 *   Please be aware of the BSL license restrictions before installing Bytedesk IM – 
 *  selling, reselling, or hosting Bytedesk IM as a service is a breach of the terms and automatically terminates your rights under the license. 
 *  仅支持企业内部员工自用，严禁用于销售、二次销售或者部署SaaS方式销售 
 *  Business Source License 1.1: https://github.com/Bytedesk/bytedesk/blob/main/LICENSE 
 *  contact: 270580156@qq.com 
 *  技术/商务联系：270580156@qq.com
 * Copyright (c) 2024 by bytedesk.com, All Rights Reserved. 
 */
package com.eazybytes.springsecOAUTH2GitHub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTH2GitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    /*
     * @Bean
     * public ClientRegistrationRepository clientRepository() {
     * ClientRegistration clientReg = clientRegistration();
     * return new InMemoryClientRegistrationRepository(clientReg);
     * }
     * 
     * private ClientRegistration clientRegistration() {
     * return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId(
     * "8cf67ab304dc500092e3")
     * .clientSecret("6e6f91851c864684af2f91eaa08fb5041162768e").build();
     * }
     */

}
