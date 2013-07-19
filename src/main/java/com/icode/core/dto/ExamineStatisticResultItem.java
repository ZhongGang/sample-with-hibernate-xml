package com.icode.core.dto;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-19
 * Time: 下午2:46
 */
public class ExamineStatisticResultItem {
    private String department;
    private BigDecimal score;

    public ExamineStatisticResultItem(String department, BigDecimal score) {
        this.department = department;
        this.score = score;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
