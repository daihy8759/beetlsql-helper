package com.github.daihy8759.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.github.daihy8759.mapper.PersonMapper;
import com.github.daihy8759.model.CurrentUser;
import com.github.daihy8759.model.Person;
import com.github.daihy8759.query.PageRequest;

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

  private Person insertPerson() {
    Person person = new Person();
    person.setAddress("test");
    CurrentUser<Long> currentUser = new CurrentUser<Long>();
    currentUser.setUserId(1L);
    personService.insert(person, currentUser);
    return person;
  }

  @Test
  public void testInsert() {
    Person person = insertPerson();
    person = personService.unique(person.getId());
    assertNotNull(person);

    personService.delete(new Long[] { person.getId() });
    assertEquals(null, personService.single(person.getId()));
  }

  @Test
  public void testUpdate() {
    Person person = insertPerson();
    person.setAddress("new address");
    CurrentUser<Long> currentUser = new CurrentUser<Long>();
    currentUser.setUserId(1L);
    person = personService.unique(person.getId());
    int affectCount = personService.update(person, currentUser);
    assertEquals(1, affectCount);
  }

  @Test
  public void testDelete() {
    Person person = insertPerson();
    int affectCount = personService.deleteById(person.getId());
    assertEquals(1, affectCount);
  }

  @Test
  public void testPageQuery() {
    PageRequest pageRequest = PageRequest.create(1, 10);
    sqlManager.getMapper(PersonMapper.class).selectPage(pageRequest);
  }

}
