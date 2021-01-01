/*
 * @Description:
 *
 * @Author: daihy
 *
 * @Github: https://github.com/daihy8759
 *
 * @Date: 2020-12-30 14:14:04
 *
 * @LastEditors: daihy
 *
 * @LastEditTime: 2020-12-30 15:02:29
 */
package com.github.daihy8759.query;

import java.util.HashMap;
import java.util.Map;
import org.beetl.sql.core.page.DefaultPageRequest;

public class PageRequest<T> extends DefaultPageRequest<T> {

    private static final long serialVersionUID = -908001773744085125L;

    private Map<String, Object> queryParas = new HashMap<>();

    public Map<String, Object> getQueryParas() {
        return queryParas;
    }

    public void setQueryParas(Map<String, Object> queryParas) {
        this.queryParas = queryParas;
    }

    @SuppressWarnings("rawtypes")
    public static PageRequest create(long page, int pageSize) {
        PageRequest request = new PageRequest();
        request.setPageNumber(page);
        request.setPageSize(pageSize);
        request.setTotalRequired(true);
        return request;
    }

}
