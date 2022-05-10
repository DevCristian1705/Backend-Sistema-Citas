package com.sisCitas.config;

import com.sisCitas.utils.SecurityUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringSecurityAuditorAware {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return ()->Optional.ofNullable(SecurityUtil.getCurrentUsername().get()).filter(s -> !s.isEmpty());
    }

}
