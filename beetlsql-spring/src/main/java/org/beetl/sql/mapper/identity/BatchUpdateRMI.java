package org.beetl.sql.mapper.identity;

import java.lang.reflect.Method;
import java.util.List;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.SqlId;
import org.beetl.sql.mapper.builder.MethodParamsHolder;

/**
 * 批量操作
 *
 * @author xiandafu
 */
public class BatchUpdateRMI extends BaseRMI {
    public BatchUpdateRMI(SqlId sqlId, MethodParamsHolder holder) {
        super(sqlId, holder);
    }

    @Override
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        return sm.updateBatch(sqlId, (List) args[0]);
    }
}
