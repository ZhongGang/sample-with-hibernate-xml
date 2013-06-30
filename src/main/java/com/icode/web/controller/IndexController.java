package com.icode.web.controller;

import com.icode.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index() {
        return "index";
    }

    @RequestMapping("search")
    public String search(Model model) throws InterruptedException {
        List results = shopService.search();
        model.addAttribute("size", results.size());
        return "index";
    }
}
