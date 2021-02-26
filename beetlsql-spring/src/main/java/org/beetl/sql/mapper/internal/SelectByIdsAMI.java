package org.beetl.sql.mapper.internal;

import java.lang.reflect.Method;
import java.util.List;
import org.beetl.sql.clazz.kit.BeetlSQLException;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.MapperInvoke;

/**
 *
 *
 * @author xiandafu
 */
public class SelectByIdsAMI extends MapperInvoke {

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        if (!(args[0] instanceof List)) {
            throw new BeetlSQLException(BeetlSQLException.MAPPING_ERROR, "期望第一个参数是List");
        }
        return sm.selectByIds(entityClass, (List) args[0]);
    }

}
