package com.icode.core.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-19
 * Time: 下午2:45
 */
public class ExamineStatisticResult {
    private List<ExamineStatisticResultItem> items = new ArrayList<ExamineStatisticResultItem>();

    public ExamineStatisticResult() {
        items.add(new ExamineStatisticResultItem("计算机软件", new BigDecimal(85)));
        items.add(new ExamineStatisticResultItem("人力资源", new BigDecimal(80)));
        items.add(new ExamineStatisticResultItem("计算机硬件", new BigDecimal(90)));
        items.add(new ExamineStatisticResultItem("维修部门", new BigDecimal(95)));
        items.add(new ExamineStatisticResultItem("相关部门", new BigDecimal(60)));
    }

    public List<ExamineStatisticResultItem> getItems() {
        return items;
    }

    public void setItems(List<ExamineStatisticResultItem> items) {
        this.items = items;
    }
}
