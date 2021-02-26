package org.beetl.sql.mapper.internal;

import java.lang.reflect.Method;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.mapper.MapperInvoke;

/**
 * create time : 2017-04-27 16:10 得到mapper接口的泛型
 * 
 * @author luoyizhu@gmail.com
 */
public class GetTargetEntityAMI extends MapperInvoke {

	@Override
	public Object call(SQLManager sm, Class mapperInterface, Class entityClass, Method m, Object[] args) {
		return entityClass;
	}

}
