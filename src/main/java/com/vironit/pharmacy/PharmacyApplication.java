package com.vironit.pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class,DataSourceAutoConfiguration.class} )
public class PharmacyApplication {
	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}
}
