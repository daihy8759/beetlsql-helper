package com.github.daihy8759;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
