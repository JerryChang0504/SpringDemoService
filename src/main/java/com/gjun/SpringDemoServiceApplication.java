package com.gjun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // 啟用 JPA 審計功能
public class SpringDemoServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDemoServiceApplication.class, args);
  }

}
