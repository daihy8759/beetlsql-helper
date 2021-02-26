package org.beetl.sql.mapper;

import java.lang.reflect.Method;
import org.beetl.sql.core.SQLManager;

public abstract class MapperInvoke {

    public abstract Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args);

}
