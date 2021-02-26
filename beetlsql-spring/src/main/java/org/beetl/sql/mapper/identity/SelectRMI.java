package org.beetl.sql.mapper.identity;

import java.lang.reflect.Method;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SqlId;
import org.beetl.sql.mapper.builder.MethodParamsHolder;

/**
 * @author xiandafu
 */
public class SelectRMI extends BaseRMI {
    Class targetType;
    boolean isSingle;

    public SelectRMI(SqlId sqlId, Class targetType, MethodParamsHolder holder, boolean isSingle) {
        super(sqlId, holder);
        this.targetType = targetType;
        this.isSingle = isSingle;
    }

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {

        if (isSingle) {
            return sm.selectSingle(sqlId, (Object) this.getParas(args), targetType);
        } else {
            return sm.select(sqlId, targetType, (Object) this.getParas(args));
        }
    }
}
