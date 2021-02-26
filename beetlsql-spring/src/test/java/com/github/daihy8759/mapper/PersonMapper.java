package com.github.daihy8759.mapper;

import com.github.daihy8759.model.Person;
import org.beetl.sql.mapper.annotation.SqlResource;
import org.springframework.stereotype.Repository;

@Repository
@SqlResource("person")
public interface PersonMapper extends BaseMapper<Person> {

}
