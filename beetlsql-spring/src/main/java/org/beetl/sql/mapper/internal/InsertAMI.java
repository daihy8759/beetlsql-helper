package org.beetl.sql.mapper.internal;

import java.lang.reflect.Method;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.MapperInvoke;

public class InsertAMI extends MapperInvoke {

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        int ret = sm.insert(args[0]);
        return ret;
    }
}