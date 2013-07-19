package com.icode.core.dto;

import com.icode.core.model.Examine;
import com.icode.core.model.Period;
import org.joda.time.LocalDate;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-19
 * Time: 下午2:08
 */
public class ExamineDTO {
    private String startDate;
    private String endDate;
    private String department;
    private String member;
    private String score;

    public ExamineDTO() {
    }

    public ExamineDTO(Examine examine) {
        this.department = examine.getDepartment();
        this.member = examine.getMember();
        this.score = examine.getScore().toString();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Examine toExamine() {
        LocalDate startDate = LocalDate.parse(this.startDate);
        LocalDate endDate = LocalDate.parse(this.endDate);
        Period period = new Period(startDate, endDate);
        BigDecimal score = new BigDecimal(this.score);
        return new Examine(period, department, member, score);
    }
}
