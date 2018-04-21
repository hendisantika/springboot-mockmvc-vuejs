package com.hendisantika.springbootmockmvcvuejs.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mockmvc-vuejs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/18
 * Time: 17.51
 * To change this template use File | Settings | File Templates.
 */
public enum StockData {
    INSTANCE;

    private Map<Long, Stock> stocks;

    public void initData() {
        stocks = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            Stock newStock = new Stock("S" + i, new BigDecimal(i));
            stocks.put(newStock.getId(), newStock);
        }
    }

    public Map<Long, Stock> getStocks() {
        return stocks;
    }
}
