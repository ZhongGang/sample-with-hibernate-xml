package com.icode.core.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

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
@Indexed(index = "Product")
@Analyzer(impl = StandardAnalyzer.class)
public class Product extends AbstractEntity {

    @Column
    @Field(store = Store.YES)
    private String name;
}
