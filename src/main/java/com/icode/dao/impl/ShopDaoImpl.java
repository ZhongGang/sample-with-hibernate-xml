package com.icode.dao.impl;

import com.icode.core.dto.ShopOverviewDTO;
import com.icode.core.model.Shop;
import com.icode.dao.ShopDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-6-23
 * Time: 上午1:09
 */
@Repository("shopDao")
public class ShopDaoImpl extends EntityDaoImpl implements ShopDao {

    @Override
    public List<ShopOverviewDTO> findShops() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select new com.icode.core.dto.ShopOverviewDTO(s) from Shop s where s.active = true");
        return query.list();
    }

    @Override
    public List search() throws InterruptedException {
        Session session = sessionFactory.openSession();
        FullTextSession fullTextSession = Search.getFullTextSession(session);
        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Shop.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onFields("name").matching("s").createQuery();
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Shop.class);
        return fullTextQuery.list();
    }
}
