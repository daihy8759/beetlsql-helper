/*
 * @Description:
 *
 * @Author: daihy
 *
 * @Github: https://github.com/daihy8759
 *
 * @Date: 2020-12-30 15:15:12
 *
 * @LastEditors: daihy
 *
 * @LastEditTime: 2021-01-01 16:08:18
 */
package com.github.daihy8759.mapper.internal;

import java.lang.reflect.Method;
import org.beetl.sql.clazz.kit.BeetlSQLException;
import org.beetl.sql.clazz.kit.StringKit;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.MapperInvoke;
import org.beetl.sql.mapper.annotation.SqlResource;

// TODO: get Sqlsource
public class GetNameSpaceAMI extends MapperInvoke {

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
        SqlResource methodSqlResoruce = m.getAnnotation(SqlResource.class);
        if (methodSqlResoruce != null) {
            return methodSqlResoruce.value();
        }
        SqlResource sqlResource = (SqlResource) mapperInterface.getAnnotation(SqlResource.class);
        if (sqlResource != null) {
            return sqlResource.value();
        }
        // 从实体名获取
        if (entityClass != null) {
            String namespace = StringKit.toLowerCaseFirstOne(entityClass.getSimpleName());
            return namespace;
        }
        throw new BeetlSQLException(BeetlSQLException.MAPPER_ERROR, "需要使用@SqlResource");
    }
}
