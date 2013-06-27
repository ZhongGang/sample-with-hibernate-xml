package com.icode.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-26
 * Time: 下午6:44
 */
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @Column
    private String name;
}
