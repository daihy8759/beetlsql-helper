package com.github.daihy8759.context;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.ttl.TransmittableThreadLocal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author daihy
 */
public class ContextHandler {

  private static final ThreadLocal<Map<String, String>> THREAD_LOCAL = new TransmittableThreadLocal<>();

  private ContextHandler() {
  }

  public static void set(String key, Object value) {
    Map<String, String> map = getLocalMap();
    map.put(key, value == null ? StrUtil.EMPTY : value.toString());
  }

  public static <T> T get(String key, Class<T> type) {
    Map<String, String> map = getLocalMap();
    return Convert.convert(type, map.get(key));
  }

  public static <T> T get(String key, Class<T> type, Object def) {
    Map<String, String> map = getLocalMap();
    return Convert.convert(type, map.getOrDefault(key, String.valueOf(def == null ? "" : def)));
  }

  public static Map<String, String> getLocalMap() {
    Map<String, String> map = THREAD_LOCAL.get();
    if (map == null) {
      map = new HashMap<>(10);
      THREAD_LOCAL.set(map);
    }
    return map;
  }

  public void unload(){
    THREAD_LOCAL.remove();
  }

  public static void setLocalMap(Map<String, String> threadLocalMap) {
    THREAD_LOCAL.set(threadLocalMap);
  }

  /**
   * 账号id
   *
   * @param userId
   */
  public static void setUserId(Object userId) {
    set(ContextConstants.KEY_USER_ID, userId);
  }

  public static Object getUserId() {
    return get(ContextConstants.KEY_USER_ID, Object.class, 0L);
  }

}
