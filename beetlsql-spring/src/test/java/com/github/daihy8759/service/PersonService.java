package com.github.daihy8759.service;

import com.github.daihy8759.mapper.PersonMapper;
import com.github.daihy8759.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends BaseService<Person, Long> {

  protected PersonService(PersonMapper baseMapper) {
    super(baseMapper);
  }
}
