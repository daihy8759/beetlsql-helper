package org.beetl.sql.mapper.internal;

import java.lang.reflect.Method;
import java.util.List;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.MapperInvoke;

/**
 * create time : 2017-04-27 16:09
 *
 * @author luoyizhu@gmail.com
 */
public class UpdateByIdBatchAMI extends MapperInvoke {

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        return sm.updateByIdBatch((List<?>) args[0]);
    }

}
