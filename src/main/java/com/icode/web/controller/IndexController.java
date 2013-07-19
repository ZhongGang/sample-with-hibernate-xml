package com.icode.web.controller;

import com.icode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-22
 * Time: 上午12:29
 */
@Controller
public class IndexController {

    @Autowired
    private ShopService shopService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

    @RequestMapping("search")
    public String search(Model model) throws InterruptedException {
        List results = shopService.search();
        model.addAttribute("size", results.size());
        return "index";
    }
}
