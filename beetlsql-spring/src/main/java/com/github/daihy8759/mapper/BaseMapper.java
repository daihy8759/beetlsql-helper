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
 * @LastEditTime: 2020-12-30 14:36:26
 */
package com.github.daihy8759.mapper;

import java.util.Map;
import com.github.daihy8759.query.PageRequest;
import org.beetl.sql.core.SqlId;
import org.beetl.sql.core.page.PageResult;
import org.beetl.sql.mapper.annotation.SqlResource;

public interface BaseMapper<T> extends org.beetl.sql.mapper.BaseMapper<T> {

    @SuppressWarnings(value = {"unchecked"})
    default String getNamespace() {
        SqlResource sqlResource = (SqlResource) getTargetEntity().getAnnotation(SqlResource.class);
        if (sqlResource != null) {
            return sqlResource.value();
        }
        return "";
    }

    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    default PageResult<T> selectPage(PageRequest pageRequest) {
        return getSQLManager().pageQuery(SqlId.of(getNamespace(), "selectPage"), getTargetEntity(),
                pageRequest.getQueryParas(), pageRequest);
    }

    @SuppressWarnings("rawtypes")
    default PageResult<Map> selectPageMap(PageRequest pageRequest) {
        return getSQLManager().pageQuery(SqlId.of(getNamespace(), "selectPage"), Map.class,
                pageRequest.getQueryParas(), pageRequest);
    }

}
