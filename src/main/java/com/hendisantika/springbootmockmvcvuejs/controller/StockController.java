package com.hendisantika.springbootmockmvcvuejs.controller;

import com.hendisantika.springbootmockmvcvuejs.model.Stock;
import com.hendisantika.springbootmockmvcvuejs.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

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
@RestController
public class StockController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/api/v1/stocks")
    public ResponseEntity<Map<Long, Stock>> findAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    @PostMapping("/api/v1/stocks")
    public ResponseEntity createANewStock(@Valid @RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.saveStock(stock));
    }

    @GetMapping("/api/v1/stocks/{stockId}")
    public ResponseEntity<Stock> findById(@PathVariable Long stockId) {
        Optional<Stock> stockOptional = stockService.findStockById(stockId);
        if (!stockOptional.isPresent()) {
            logger.severe("StockId " + stockId + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stockOptional.get());
    }

    @PutMapping("/api/v1/stocks/{stockId}")
    public ResponseEntity<Stock> updatePriceOfAStock(@PathVariable Long stockId, BigDecimal currentPrice) {
        Optional<Stock> stockOptional = stockService.findStockById(stockId);
        if (!stockOptional.isPresent()) {
            logger.severe("StockId " + stockId + " is not existed");
            ResponseEntity.badRequest().build();
        }

        Stock stock = stockOptional.get();
        stock.setCurrentPrice(currentPrice);

        return ResponseEntity.ok(stockService.saveStock(stock));
    }
}