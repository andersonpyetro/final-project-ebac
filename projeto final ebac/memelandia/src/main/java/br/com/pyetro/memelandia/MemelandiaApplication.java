package br.com.pyetro.memelandia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.pyetro.memelandia.feign")
public class MemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaApplication.class, args);
	}

}
