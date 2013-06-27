package com.icode.core.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Shop extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    @Fetch(value = FetchMode.JOIN)
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
}
