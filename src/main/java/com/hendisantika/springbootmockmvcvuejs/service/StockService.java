package com.hendisantika.springbootmockmvcvuejs.service;

import com.hendisantika.springbootmockmvcvuejs.model.Stock;
import com.hendisantika.springbootmockmvcvuejs.model.StockData;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mockmvc-vuejs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/04/18
 * Time: 17.50
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StockService {
    public Map<Long, Stock> findAll() {
        return StockData.INSTANCE.getStocks();
    }

    public Optional<Stock> findStockById(Long id) {
        return Optional.ofNullable(StockData.INSTANCE.getStocks().getOrDefault(id, null));
    }

    public Stock saveStock(Stock stock) {
        StockData.INSTANCE.getStocks().put(stock.getId(), stock);
        return stock;
    }
}
