package com.icode.web.view.resolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-11
 * Time: 下午5:03
 */
public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        view.setPrettyPrint(true);
        return view;
    }
}
