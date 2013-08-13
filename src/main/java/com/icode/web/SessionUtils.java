package com.icode.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-13
 * Time: 下午3:42
 */
public class SessionUtils {

    public static Object getAttribute(HttpServletRequest request, String key, Object defaultValue) {
        HttpSession session = request.getSession();
        Object value = session.getAttribute(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }
}
