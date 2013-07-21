package com.icode.core.transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-21
 * Time: 下午9:40
 */
public class DefaultWorker implements Worker {
    private static final Log LOG = LogFactory.getLog(DefaultWorker.class);
    private int count = 0;

    private int value;

    public DefaultWorker() {
    }

    public DefaultWorker(int count) {
        this.count = count;
    }

    @Override
    public void work(int value) {
        this.value = value;
        this.count += value;
    }

    @Override
    public void commit() {
        LOG.debug("The method named commit is invoked, the count is " + this.count);
    }

    @Override
    public void rollback() {
        this.count -= this.value;
        LOG.debug("The method named rollback is invoked, the count is " + this.count);
    }
}
