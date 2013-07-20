package com.icode.core.model;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-22
 * Time: 下午4:11
 */
@Entity
@Table(name = "shop")
@Indexed(index = "Shop")
@Analyzer(impl = StandardAnalyzer.class)
public class Shop extends AbstractEntity {
    @Column
    @Field(store = Store.YES, analyzer = @Analyzer(impl = StandardAnalyzer.class))
    private String name;

    @Column
    @Field(store = Store.YES)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    @Fetch(value = FetchMode.JOIN)
    @Index(name = "shop_index")
    private List<Product> products = new ArrayList<Product>();

    public Shop() {
    }

    public Shop(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Product> getProducts() {
        return products;
    }
}
