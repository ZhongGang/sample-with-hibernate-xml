package com.icode.core.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-19
 * Time: 下午2:02
 */
@Embeddable
public class Period {

    @Column(name = "start_date", columnDefinition = "date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate start;

    @Column(name = "end_date", columnDefinition = "date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate end;

    public Period() {
    }

    public Period(LocalDate startDate, LocalDate endDate) {
        this.start = startDate;
        this.end = endDate;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
