package com.anb.auditLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing//(auditorAwareRef = "auditorAware")
public class AuditLogApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(AuditLogApplication.class, args);
	}

}
