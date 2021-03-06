package com.icode.dao.impl;

import com.icode.core.model.Product;
import com.icode.core.model.Shop;
import com.icode.core.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 下午1:41
 */
@ContextConfiguration(locations = "classpath:rootApplicationContext.xml")
public class EntityDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    public void testSaveOrUpdate() throws Exception {
        for (int i = 0; i < 100000; i++) {
            Shop shop = new Shop("Shop" + i, "Shop" + i);
            Session session = sessionFactory.getCurrentSession();
            session.persist(shop);

            session.close();

            Transaction transaction = session.getTransaction();

            transaction.begin();

            transaction.commit();

        }
    }

    @Test
    public void testNPlusOneProblem() throws Exception {
        Session session = sessionFactory.openSession();

        Shop shop1 = new Shop();
        shop1.add(new Product());
        shop1.add(new Product());
        session.saveOrUpdate(shop1);

        Shop shop2 = new Shop();
        shop2.add(new Product());
        shop2.add(new Product());
        shop2.add(new Product());
        session.saveOrUpdate(shop2);

        Shop shop3 = new Shop();
        shop3.add(new Product());
        shop3.add(new Product());
        shop3.add(new Product());
        shop3.add(new Product());
        session.saveOrUpdate(shop3);

        session.flush();
        session.clear();

        List<Shop> shops = session.createCriteria(Shop.class).list();
        List<Product> products = shops.get(0).getProducts();
        System.out.println(products.size());
    }

    @Test
    public void testGetNativeConnection() throws Exception {
        DataSource dataSource = SessionFactoryUtils.getDataSource(sessionFactory);
        Connection connection = DataSourceUtils.getConnection(dataSource);

    }


    @Test
    public void testIdGenerator() throws Exception {
        Session session = sessionFactory.openSession();

        Shop shop = new Shop();

        Assert.assertNull(shop.getId());

        session.saveOrUpdate(shop);

        Assert.assertNotNull(shop.getId());
    }

    @Test
    public void testSession() throws Exception {
        Session currentSession = sessionFactory.getCurrentSession();

        User user = new User();
        currentSession.saveOrUpdate(user);

        User result = (User) currentSession.get(User.class, user.getId());
        Assert.assertNull(result.getUsername());

        user.setUsername("ZhongGang");
        currentSession.saveOrUpdate(user);

        result = (User) currentSession.get(User.class, user.getId());
        Assert.assertEquals(result.getUsername(), "ZhongGang");

//        currentSession.evict(result);
//        currentSession.merge(result);

        List<String> userNames = jdbcTemplate.queryForList("select username from user", String.class);
        Assert.assertEquals(userNames.get(0), "ZhongGang");

        Query query = currentSession.createQuery("from User");
        List<User> users = query.list();
        Assert.assertEquals(users.get(0).getUsername(), "ZhongGang");

    }

}
