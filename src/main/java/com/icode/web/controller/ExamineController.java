package com.icode.web.controller;

import com.icode.core.dto.ExamineDTO;
import com.icode.core.dto.ExamineStatisticResult;
import com.icode.service.ShopService;
import com.icode.web.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 */
@Controller
@RequestMapping("/examine")
public class ExamineController {

    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("examineForm", "examine", new ExamineDTO());
    }

    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String submitForm(ExamineDTO examine) {
        shopService.saveOrUpdateExamine(examine);
        return "redirect:overview";
    }

    @RequestMapping(value = "overview")
    public ModelAndView overview() {
        List<ExamineDTO> examineDTOs = shopService.loadExamines();
        return new ModelAndView("examinesOverview", "examines", examineDTOs);
    }

    @RequestMapping(value = "statistic")
    public ModelAndView statistic(HttpServletRequest request) {
        ExamineStatisticResult result = new ExamineStatisticResult();

        HttpSession session = request.getSession();
        Integer visitCount = (Integer) SessionUtils.getAttribute(request, "visitCount", Integer.valueOf(0));
        session.setAttribute("visitCount", ++visitCount);

        return new ModelAndView("examineStatisticOverview", "result", result);
    }
}
