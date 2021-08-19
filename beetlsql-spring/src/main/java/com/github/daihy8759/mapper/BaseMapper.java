/*
 * @Description:
 *
 * @Author: daihy
 *
 * @Github: https://github.com/daihy8759
 *
 * @Date: 2020-12-30 14:18:52
 *
 * @LastEditors: daihy
 *
 * @LastEditTime: 2021-01-07 09:32:54
 */
package com.github.daihy8759.mapper;

import com.github.daihy8759.query.PageRequest;
import java.util.Map;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.annotation.InheritMapper;

public interface BaseMapper<T> extends org.beetl.sql.mapper.BaseMapper<T> {

  @InheritMapper
  PageResult<T> selectPage(PageRequest pageRequest);

  @InheritMapper
  PageResult<Map> selectPageMap(PageRequest pageRequest);

}
