package com.icode.core.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-19
 * Time: 下午2:02
 */
@Entity
@Table
public class Examine extends AbstractEntity {

    @Embedded
    private Period period;

    private String department;

    private String member;

    @Column(columnDefinition = "decimal(8,2)")
    private BigDecimal score;

    public Examine() {
    }

    public Examine(Period period, String department, String member, BigDecimal score) {
        this.period = period;
        this.department = department;
        this.member = member;
        this.score = score;
    }

    public Period getPeriod() {
        return period;
    }

    public String getDepartment() {
        return department;
    }

    public String getMember() {
        return member;
    }

    public BigDecimal getScore() {
        return score;
    }
}
