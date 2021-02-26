package org.beetl.sql.mapper.internal;

import java.lang.reflect.Method;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SQLReady;
import org.beetl.sql.mapper.MapperInvoke;

/**
 * create time : 2017-04-27 16:09
 *
 * @author luoyizhu@gmail.com
 */
public class ExecuteAMI extends MapperInvoke {

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        return sm.execute(new SQLReady((String) args[0], (Object[]) args[1]), entityClass);
    }

}
