package com.github.daihy8759.config;

import org.beetl.sql.starter.SQLManagerCustomize;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author daihy
 */
@Configuration
@Import(DataSourceAutoConfiguration.class)
public class BeetlSQLConfig {

  @Bean
  public SQLManagerCustomize sqlManagerCustomize() {
    return (sqlManagerName, manager) -> {
      System.out.println(1);
    };
  }
}
