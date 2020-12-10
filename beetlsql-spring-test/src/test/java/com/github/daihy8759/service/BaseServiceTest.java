package com.github.daihy8759.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.daihy8759.model.CurrentUser;
import com.github.daihy8759.model.Person;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.ext.DBInitHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
@Profile("test")
@TestInstance(Lifecycle.PER_CLASS)
public class BaseServiceTest {

  @Autowired
  private PersonService personService;
  @Autowired
  private SQLManager sqlManager;

  @BeforeAll
  public void init() {
    DBInitHelper.executeSqlScript(sqlManager, "db/schema.sql");
  }

  @Test
  public void testInsert() {
    Person person = new Person();
    person.setAddress("test");
    CurrentUser currentUser = new CurrentUser();
    currentUser.setUserId(1L);
    personService.insert(person, currentUser);

    assertNotNull(person.getId());

    assertNotNull(personService.unique(person.getId()));

    personService.delete(new Long[]{person.getId()});

    assertEquals(null, personService.single(person.getId()));
  }

}
