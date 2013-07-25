package com.icode.guava;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-25
 * Time: 下午11:08
 */
public class CollectionTest {

    @Test
    public void testCollection() throws Exception {
        ArrayList<String> list = Lists.newArrayList("1", "2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
